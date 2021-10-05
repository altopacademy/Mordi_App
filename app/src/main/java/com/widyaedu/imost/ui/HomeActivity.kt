package com.widyaedu.imost.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.widyaedu.imost.R
import com.widyaedu.imost.databinding.ActivityHomeBinding
import com.widyaedu.imost.fragment.OtherFragment
import com.widyaedu.imost.fragment.PesanFragment
import com.widyaedu.imost.fragment.TransaksiFragment
import com.widyaedu.imost.listener.ClickHelper
import com.widyaedu.imost.ui.product.ListProductActivity

class HomeActivity : AppCompatActivity(), ClickHelper {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val home = HomeFragment.newInstance("Tes")
        val pesan = PesanFragment.newInstance("Tes")
        val trx= ListProductActivity
        val other = OtherFragment.newInstance("Tes")

        setFragment(home)

        binding.nav.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> {
                    setFragment(home)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.pesan -> {
                    setFragment(pesan)
                    return@setOnNavigationItemSelectedListener true
                }
//                R.id.trx -> {
//                    val intent = Intent(this, ListProductActivity::class.java)
//                    startActivity(intent)
//                    return@setOnNavigationItemSelectedListener true
//                }
                R.id.other -> {
                    setFragment(other)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val i = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_HOME)
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(i)
    }

    override fun click() {

    }
}