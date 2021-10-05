package com.widyaedu.imost.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.*
import com.bumptech.glide.Glide
import com.widyaedu.imost.R
import com.widyaedu.imost.preferences.PreferencesManager

class WelcomeActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var btnmulai: Button
    private lateinit var btnSkip: Button
    private lateinit var dotsLayout: LinearLayout
    private var myViewPagerAdapter: MyViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        PreferencesManager(this).putWelcomed()

        viewPager = findViewById(R.id.view_pager)
        dotsLayout = findViewById(R.id.layoutDots)
        btnmulai = findViewById(R.id.btn_mulai)
        btnSkip = findViewById(R.id.btSkip)

        initIndicator()
        myViewPagerAdapter = MyViewPagerAdapter()
        viewPager.adapter = myViewPagerAdapter
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener)
        btnSkip.setOnClickListener { launchHomeScreen() }

        btnmulai.setOnClickListener {
            launchHomeScreen()
        }
    }

    private fun getItem(): Int {
        return viewPager.currentItem + 1
    }

    private fun launchHomeScreen() {
        PreferencesManager(this).putWelcomed()
        startActivity(Intent(this@WelcomeActivity, LoginActivity::class.java))
        finish()
    }

    private var viewPagerPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            for (i in lImage.indices) {
                val iv = lImage[i]
                if (i == position) {
                    iv.setImageResource(R.drawable.ic_dot_accent)
                } else {
                    iv.setImageResource(R.drawable.ic_dot_beige)
                }
            }
            if (position == 2) {
                btnmulai.visibility = VISIBLE
                btnSkip.visibility = INVISIBLE
                dotsLayout.visibility = INVISIBLE
            } else {
                btnmulai.visibility = INVISIBLE
                btnSkip.visibility = VISIBLE
                dotsLayout.visibility = VISIBLE
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
        override fun onPageScrollStateChanged(arg0: Int) {}
    }
    private val lImage: MutableList<ImageView> = ArrayList()
    private fun initIndicator() {
        dotsLayout.removeAllViews()
        for (i in 0..2) {
            val iv = ImageView(this)
            if (i == 0) {
                iv.setPadding(5, 0, 5, 0)
                iv.setImageResource(R.drawable.ic_dot_accent)
            } else {
                iv.setPadding(5, 0, 5, 0)
                iv.setImageResource(R.drawable.ic_dot_beige)
            }
            lImage.add(iv)
            dotsLayout.addView(iv)
        }
    }

    inner class MyViewPagerAdapter : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = layoutInflater!!.inflate(R.layout.fragment_welcome, container, false)
            val iv = view.findViewById<ImageView>(R.id.ivImage)
            val title = view.findViewById<TextView>(R.id.tvTitle)
            val desc = view.findViewById<TextView>(R.id.tvDeskripsi)

            val sTitle: String
            val sDesc: String
            val img: Int

            when (position) {
                0 -> {
                    sTitle = "Mengurangi Resiko Penyakit"
                    sDesc =
                        "Mengurangi risiko keparahan kondisi retinopati diabetik pada penderita diabetes dengan alat monitoring kondisi mata secara cermat dan efisien"
                    img = R.drawable.eyer
                }
                1 -> {
                    sTitle = "Monitoring"
                    sDesc =
                        "Pemantauan secara mandiri oleh pasien melalui  aplikasi pada smartphone dengan hasil interpretasi yang terekam dan terhubung dengan dokter  atau fasilitas pelayanan kesehatan terkait"
                    img = R.drawable.monitor
                }
                else -> {
                    sTitle = "Dokter"
                    sDesc = "Memudahkan dokter dan fasilitas pelayanan kesehatan dalam memantau kondisi mata pasien diabetes."
                    img = R.drawable.doctor
                }
            }

            Glide.with(view).load(img).into(iv)
            title.text = sTitle
            desc.text = sDesc

            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return 3
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }
    }
}