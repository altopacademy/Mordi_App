package com.widyaedu.imost.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.widyaedu.imost.databinding.ActivityOtpBinding
import java.util.concurrent.TimeUnit

class OtpActivity : AppCompatActivity() {
    companion object{
        const val PHONE_KEY = "extra_phone"
    }
    private lateinit var binding: ActivityOtpBinding
    private lateinit var phone : String
    private lateinit var auth: FirebaseAuth
    var sp: SharedPreferences? = null
    private var verifID = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        phone = intent?.getStringExtra(PHONE_KEY).toString()
        sp = getSharedPreferences("login", MODE_PRIVATE)
        verifyPhone(phone)
        showTimer(phone)

        initEditor()
    }

    private fun initEditor() {
        with(binding) {
            et1.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    et2.requestFocus()
                }
            }
            et2.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    et3.requestFocus()
                }
            }
            et3.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    et4.requestFocus()
                }
            }
            et4.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    et5.requestFocus()
                }
            }
            et5.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    et6.requestFocus()
                }
            }
            et6.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    btVerif.requestFocus()
                }
            }
        }
    }

    private fun verifyPhone(phone: String) {
        val option = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phone)
            .setTimeout(30L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callback)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(option)
    }

    private val callback : PhoneAuthProvider.OnVerificationStateChangedCallbacks =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                val code = p0.smsCode
                if (code != null){
                    verifyCode(code)
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                if (p0 is FirebaseAuthInvalidCredentialsException){
                    Toast.makeText(this@OtpActivity, p0.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(p0, p1)
                verifID = p0

            }
        }

    private fun verifyCode(code: String) {
        binding.btVerif.setOnClickListener {
            val codesent = "${binding.et1.text}${binding.et2.text}${binding.et3.text}${binding.et4.text}${binding.et5.text}${binding.et6.text}"
            if (code == codesent){
                val credential = PhoneAuthProvider.getCredential(verifID, code)
                Toast.makeText(this, "Kode Anda ${codesent}", Toast.LENGTH_SHORT).show()
                signWithPhone(credential)
            } else {
                Toast.makeText(this, "Kode Error", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun signWithPhone(phone: PhoneAuthCredential) {
        auth.signInWithCredential(phone)
            .addOnCompleteListener (
                this@OtpActivity
            ) { task ->
                if (task.isSuccessful) {
                    val i = Intent(this, HomeActivity::class.java)
                    startActivity(i)
                    sp?.edit()?.putBoolean("login", true)?.apply()
                    Toast.makeText(this,"Berhasil", Toast.LENGTH_SHORT).show()
                }
            }

    }

    private fun showTimer(phone: String){
        val timer = object : CountDownTimer(30000, 1000){
            override fun onTick(p0: Long) {
                binding.tvTimer.text = "Tunggu sampai ${p0/1000}"
            }

            override fun onFinish() {
                binding.tvResend.visibility = View.VISIBLE
                binding.tvTimer.text = "Tidak Menerima OTP? "
                binding.tvResend.setOnClickListener {
                    showTimer(phone)
                    verifyPhone(phone)
                    binding.tvResend.visibility = View.GONE
                }
            }
        }
        timer.start()
    }
}