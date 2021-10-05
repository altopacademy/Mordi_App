package com.widyaedu.imost.fragment

import android.app.AlertDialog
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.widyaedu.imost.BuildConfig
import com.widyaedu.imost.R
import com.widyaedu.imost.databinding.FragmentOtherBinding
import com.widyaedu.imost.model.User
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.ui.LoginActivity
import com.widyaedu.imost.ui.UpdateProfile
import com.widyaedu.imost.ui.UpdateProfile.Companion.ID_USER
import com.widyaedu.imost.ui.salesrole.ListMyPayment
import com.widyaedu.imost.ui.salesrole.ListMyRating
import com.widyaedu.imost.viewmodel.ItemViewModel


class OtherFragment : Fragment() {

    private lateinit var binding: FragmentOtherBinding
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var pref: PreferencesManager
    var preferences : SharedPreferences? = null

    companion object {
        fun newInstance(data: String): OtherFragment {
            val args = Bundle()
            args.putString("data", data)
            val f = OtherFragment()
            f.arguments = args
            return f
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOtherBinding.inflate(inflater)
        itemViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)
        pref = PreferencesManager(this.requireContext())
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this.requireContext(), gso)
        binding.tvLogout.setOnClickListener {
            alert()
        }
        binding.tvVersion.text = BuildConfig.VERSION_NAME
        itemViewModel.getUserById(pref.getUser())
        hideButton(pref.getRole())
        preferences = activity?.getSharedPreferences("login", MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemViewModel.user.observe(viewLifecycleOwner, {
            showNama(it.data)
        })

    }

    private fun alert() {
        val builder = AlertDialog.Builder(this.requireContext())
        builder.setTitle("Exit Aplication")
        builder.setMessage("Apakah Anda akan keluar?")
        builder.setPositiveButton("YES") { dialog, which ->
            mGoogleSignInClient.signOut().addOnCompleteListener {
                val i = Intent(this.requireActivity(), LoginActivity::class.java)
                startActivity(i)
                val editor = preferences?.edit()
                editor?.clear()
                editor?.apply()
            }
        }

        builder.setNegativeButton("NO") { dialog, which ->
            Toast.makeText(
                this.requireContext(),
                "Terima Kasih Tidak Jadi Keluar",
                Toast.LENGTH_SHORT
            ).show()
        }

        builder.show()
    }

    private fun showNama(user: User?) {
        binding.tvNama.text = user?.name
        if (user?.email.isNullOrEmpty()){
            binding.tvNomor.text = user?.phone_number
        } else {
            binding.tvNomor.text = user?.email
        }

        Glide.with(this.requireContext()).load(user?.photo).into(binding.ivProfileUser)
    }

    private fun hideButton(role: String){

    }
}