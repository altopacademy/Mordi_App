package com.widyaedu.imost.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import com.widyaedu.imost.BuildConfig
import com.widyaedu.imost.adapter.LiveChatAdapter
import com.widyaedu.imost.databinding.ActivityPesanBinding
import com.widyaedu.imost.model.ChatModel
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.utils.Tools
import com.widyaedu.imost.viewmodel.ItemViewModel
import id.zelory.compressor.Compressor
import kotlinx.coroutines.launch
import pl.aprilapps.easyphotopicker.DefaultCallback
import pl.aprilapps.easyphotopicker.EasyImage
import pl.aprilapps.easyphotopicker.MediaFile
import pl.aprilapps.easyphotopicker.MediaSource
import java.io.File

class PesanActivity : AppCompatActivity() {
    companion object {
        const val SALES_KEY = "extra_key"
        val PERMISSIONS_STORAGE = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }

    private lateinit var binding: ActivityPesanBinding
    private lateinit var productViewModel: ItemViewModel
    private var liveChatAdapter: LiveChatAdapter? = null
    private var db = FirebaseFirestore.getInstance()
    private var user = FirebaseAuth.getInstance().currentUser

    private lateinit var easyImage: EasyImage
    private var code: String = ""
    private var pic: String = ""

    private lateinit var pref: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPesanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)

        pref = PreferencesManager(this)
        easyImage = EasyImage.Builder(this)
            .allowMultiple(false)
            .build()

        val userId = intent?.getStringExtra(SALES_KEY)
        pic = pref.getPhoto()
        productViewModel.getSalesId(userId.toString())

        productViewModel.salesInfo.observe(this, {
            binding.tvSalesNama.text = it.name
            if (intent.hasExtra("name")) {
                binding.tvSalesNama.text = intent.getStringExtra("name")
            }

            if (pref.getRole() == "Sales") {
                addCode(pref.getUser(), userId.toString())
            } else {
                addCode(userId.toString(), pref.getUser())
            }

        })

        //Log.d(getClassName(), "salesId: ${userId}")
        //Log.d(getClassName(), "customerId: ${pref.getUser()}")
        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    private fun setupChat() {
        val query = db.collection("room").document(code).collection("chat").orderBy(
            "time",
            Query.Direction.ASCENDING
        )

        val option: FirestoreRecyclerOptions<ChatModel> =
            FirestoreRecyclerOptions.Builder<ChatModel>().setQuery(
                query,
                ChatModel::class.java
            ).build()

        liveChatAdapter = LiveChatAdapter(option, this, pic)

        binding.rvChat.layoutManager = LinearLayoutManager(this)
        liveChatAdapter?.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                binding.rvChat.scrollToPosition(liveChatAdapter!!.itemCount - 1)
            }
        })
        binding.rvChat.adapter = liveChatAdapter
        liveChatAdapter?.startListening()

        binding.btnSend.setOnClickListener {
            sendChat(null)
        }

        binding.ivImg.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        val permission =
            ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                PERMISSIONS_STORAGE,
                121
            )
            return
        }
        easyImage.openGallery(this)
    }


    private var uploadTask: UploadTask? = null
    private var compressed: File? = null
    private fun uploadImg(data: Uri) {
        binding.pbUpload.visibility = VISIBLE
        lifecycleScope.launch {
            val storageRef = FirebaseStorage.getInstance()
                .getReferenceFromUrl(BuildConfig.STORAGE_URL).child("files")
            compressed = Compressor.compress(baseContext, File(data.path!!))

            val reference = storageRef
                .child(FirebaseAuth.getInstance().currentUser!!.email!!)
                .child(data.toString())

            uploadTask = reference.putFile(Uri.fromFile(compressed))

            uploadTask!!.addOnProgressListener { taskSnapshot: UploadTask.TaskSnapshot ->
                val progress =
                    100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount
                binding.pbUpload.progress = progress.toInt()
                if (progress > 99) {
                    binding.pbUpload.visibility = GONE
                }
            }
            uploadTask!!.addOnFailureListener {
                Tools.getSnackShort("Gagal Upload", binding.root).show()
            }.addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot ->
                if (taskSnapshot.metadata != null) {
                    if (taskSnapshot.metadata!!.reference != null) {
                        val result = taskSnapshot.storage.downloadUrl
                        result.addOnSuccessListener { uri: Uri ->
                            sendChat(uri.toString())
                        }
                    }
                }
            }
        }
    }

    private fun sendChat(url: String?) {
        val chatRef = db.collection("room").document(code).collection("chat")
        val chat = ChatModel(
            user?.uid.toString(),
            user?.displayName.toString(),
            binding.edtChat.text.toString(),
            FieldValue.serverTimestamp(),
            url
        )
        chatRef.add(chat)
        binding.edtChat.setText("")
    }

    override fun onStart() {
        super.onStart()
        liveChatAdapter?.startListening()
    }

    override fun onStop() {
        super.onStop()
        liveChatAdapter?.stopListening()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 121 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            openGallery()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        try {
            easyImage.handleActivityResult(
                requestCode,
                resultCode,
                data,
                this,
                object : DefaultCallback() {
                    override fun onMediaFilesPicked(
                        imageFiles: Array<MediaFile>,
                        source: MediaSource
                    ) {
                        uploadImg(Uri.fromFile(imageFiles[0].file))
                    }

                    override fun onImagePickerError(
                        error: Throwable,
                        source: MediaSource
                    ) {
                        Tools.getSnackShort(error.localizedMessage, binding.root).show()
                    }

                    override fun onCanceled(source: MediaSource) {}
                })
        } catch (e: Exception) {
            Tools.getSnackShort(
                "Error mengambil file, coba lagi!\n${e.localizedMessage}",
                binding.root
            ).show()
        }
    }

    private fun addCode(salesId: String, customerId: String){
        productViewModel.addnewRoom(salesId, customerId) { data ->

            code = if (data.status == 0) {
                data.data.code!!
            } else {
                data.data.code!!
            }

            setupChat()
            //Log.d(getClassName(), "status code: ${data.data.code}")
        }
    }
}