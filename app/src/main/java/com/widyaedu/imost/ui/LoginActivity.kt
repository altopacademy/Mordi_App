package com.widyaedu.imost.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.widyaedu.imost.R
import com.widyaedu.imost.databinding.ActivityLoginBinding
import com.widyaedu.imost.ui.OtpActivity.Companion.PHONE_KEY


class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    val RC_SIGN_IN = 9001
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mGoogleSignInOptions: GoogleSignInOptions
    var sp: SharedPreferences? = null
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        with(binding) {
            btGoogle.setOnClickListener(this@LoginActivity)
            btLanjut.setOnClickListener(this@LoginActivity)
        }

        sp = getSharedPreferences("login",MODE_PRIVATE)
        configureSignIn()
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.btGoogle -> signIn()
            binding.btLanjut -> Toast.makeText(this,
                "Mohon Maaf, saat ini fitur login dengan nomor HP tidak tersedia.",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun configureSignIn() {
        mGoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, mGoogleSignInOptions)
    }

    private fun signIn() {
        val intentSignIn = mGoogleSignInClient.signInIntent
        startActivityForResult(intentSignIn, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                account?.idToken?.let { firebaseAuth(it) }
            } catch (e: ApiException) {
                Toast.makeText(this, "Failed Login", Toast.LENGTH_SHORT).show()
                //Log.w("Google Acunt", "failed", e)
            }
        }
    }

    private fun firebaseAuth(idToken: String) {
        showBar()
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { t ->
                if (t.isSuccessful) {

                    val intent = Intent(this, HomeActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    }
                    startActivity(intent)
                    sp?.edit()?.putBoolean("login", true)?.apply()
                } else {
                    Toast.makeText(this, "Failed Login", Toast.LENGTH_SHORT).show()
                }
            }

    }

    private fun signWithPhone(){
        val numPhone = binding.etPhone.text.toString()
        val numsend = numPhone.replaceFirst("0", "+62")
        if (binding.etPhone.length() < 10){
            Toast.makeText(this, "Please Valid Number", Toast.LENGTH_SHORT).show()
        }
         else {
            val i = Intent(this, OtpActivity::class.java).apply {
                putExtra(PHONE_KEY, numsend)
            }
            startActivity(i)

        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val i = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_HOME)
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(i)
    }
    private fun showBar(){
        binding.pbSignin.visibility = View.VISIBLE
    }

    override fun onStart() {
        super.onStart()
        if(sp?.getBoolean("login",false) == true){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}