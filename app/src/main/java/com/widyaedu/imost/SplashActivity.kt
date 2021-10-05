package com.widyaedu.imost

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.widyaedu.imost.databinding.ActivitySplashBinding
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.ui.LoginActivity
import com.widyaedu.imost.ui.UpdateActivity
import com.widyaedu.imost.ui.WelcomeActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide
            .with(this)
            .load(R.drawable.splash1)
            .centerCrop()
            .into(binding.ivSplash)

        FirebaseDatabase.getInstance().reference.child("minVersion")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val version = snapshot.value as Long
                    if (BuildConfig.VERSION_CODE < version.toInt()) {
                        val i = Intent(this@SplashActivity, UpdateActivity::class.java)
                        i.apply {
                            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        }
                        startActivity(i)
                        finish()
                    } else {
                        GlobalScope.launch {
                            delay(500)
                            if (PreferencesManager(this@SplashActivity).isWelcomed()) {
                                startActivity(Intent(this@SplashActivity,
                                    LoginActivity::class.java))
                            } else {
                                startActivity(Intent(this@SplashActivity,
                                    WelcomeActivity::class.java))
                            }
                            finish()
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }
}