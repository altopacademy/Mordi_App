package com.widyaedu.imost.ui.product

import android.os.Bundle
import android.os.SystemClock
import android.view.MotionEvent
import android.view.View
import android.view.View.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.gson.Gson
import com.jakewharton.rxbinding4.widget.textChangeEvents
import com.toptoche.searchablespinnerlibrary.SearchableSpinner
import com.widyaedu.imost.R
import com.widyaedu.imost.adapter.TabsProductAdapter
import com.widyaedu.imost.databinding.ActivityListProductBinding
import com.widyaedu.imost.model.CityItem
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.viewmodel.ItemViewModel
import java.util.concurrent.TimeUnit

class ListProductActivity : AppCompatActivity() {
    companion object {
        const val PRODUCT_TYPE = "type"
    }

    private lateinit var binding: ActivityListProductBinding
    private lateinit var productViewModel: ItemViewModel
    private lateinit var searchableSpinner: SearchableSpinner
    private var cityId: String = ""
    private var listCity = mutableListOf<CityItem>()
    private lateinit var pref: PreferencesManager
    private var type = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.app_bar))
        pref = PreferencesManager(this)
        type = intent?.getStringExtra(PRODUCT_TYPE).toString()
        productViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)

        productViewModel.getSales(cityId, pref.getRole(), "")

        searchableSpinner = SearchableSpinner(this)

        title = ""
        back()
        showLoading(true)
        productViewModel.getCityList()
        productViewModel.cityItem.observe(this, { data ->
            if (data != null) {
                listCity.addAll(data)
                showLoading(false)
            } else {
                showLoading(true)
            }
        })
        getType(type, pref.getRole())
        showSpinner(listCity)
        initSearch()
    }

    private fun initSearch() {
        binding.vpTryout.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.etSearch.visibility = VISIBLE
                        binding.tvMap.visibility = VISIBLE
                        type = "kuota"
                    }
                    1 -> {
                        binding.etSearch.visibility = VISIBLE
                        binding.tvMap.visibility = VISIBLE
                        type = "nomor_cantik"
                    }
                    2 -> {
                        binding.tvMap.visibility = VISIBLE
                        binding.etSearch.visibility = GONE
                        type = "sales"
                    }
                    3 -> {
                        binding.etSearch.visibility = VISIBLE
                        binding.tvMap.visibility = VISIBLE
                        type = "pulsa"
                    }
                    4 -> {
                        binding.etSearch.visibility = VISIBLE
                        binding.tvMap.visibility = INVISIBLE
                        type = "post_paid"
                    }
                    5 -> {
                        binding.etSearch.visibility = VISIBLE
                        binding.tvMap.visibility = INVISIBLE
                        type = "bundling"
                    }
                    else -> binding.etSearch.visibility = GONE
                }
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        binding.etSearch.textChangeEvents()
            .debounce(1100, TimeUnit.MILLISECONDS)
            .subscribe {
                productViewModel.getSales(cityId, pref.getRole(), binding.etSearch.text.toString())
            }
    }

    private fun showSpinner(itemCity: List<CityItem>) {

        val downTime: Long = SystemClock.uptimeMillis()
        val eventTime: Long = SystemClock.uptimeMillis() + 100
        val x = 0.0f
        val y = 0.0f
        val metaState = 0
        val motionEvent = MotionEvent.obtain(
            downTime,
            eventTime,
            MotionEvent.ACTION_UP,
            x,
            y,
            metaState
        )

        binding.tvMap.setOnClickListener { binding.spinnerProduct.dispatchTouchEvent(motionEvent) }
        binding.spinnerProduct.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, itemCity)
        binding.spinnerProduct.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    cityId = itemCity[p2].city_id
                    binding.tvMap.text = itemCity[p2].name

                    productViewModel.getSales(cityId,
                        pref.getRole(),
                        binding.etSearch.text.toString())
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
    }

    private fun back() {
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getType(type: String?, role: String) {
        if (role == "Admin") {
            productViewModel.sales.observe(this, { item ->
                binding.etSearch.clearFocus()

                val list = mutableListOf<ProductItem>()

                for (i in productViewModel.kuota) {
                    if (i.is_verified!! == "1") {
                        list.add(i)
                    }
                }
                val nomor = mutableListOf<ProductItem>()

                for (i in productViewModel.nomor) {
                    if (i.is_verified!! == "1") {
                        nomor.add(i)
                    }
                }
                val pulsa = mutableListOf<ProductItem>()

                for (i in productViewModel.pulsa) {
                    if (i.is_verified!! == "1") {
                        pulsa.add(i)
                    }
                }

                binding.vpTryout.adapter =
                    TabsProductAdapter(
                        supportFragmentManager,
                        Gson().toJson(list.toList()),
                        Gson().toJson(nomor.toList()),
                        Gson().toJson(item),
                        Gson().toJson(pulsa.toList()),
                        Gson().toJson(productViewModel.post),
                        Gson().toJson(productViewModel.bundling),
                        "",
                        false
                    )
                binding.tlTryout.setupWithViewPager(binding.vpTryout)

                binding.vpTryout.currentItem = when (type) {
                    "kuota" -> 0
                    "nomor_cantik" -> 1
                    "sales" -> 2
                    "pulsa" -> 3
                    "post_paid" -> 4
                    "bundling" -> 5
                    else -> 6
                }
            })
        } else {
            productViewModel.sales.observe(this, { item ->
                binding.etSearch.clearFocus()

                val list = mutableListOf<ProductItem>()

                for (i in productViewModel.kuota) {
                    if (i.is_verified!! == "1") {
                        list.add(i)
                    }
                }
                val nomor = mutableListOf<ProductItem>()

                for (i in productViewModel.nomor) {
                    if (i.is_verified!! == "1") {
                        nomor.add(i)
                    }
                }
                val pulsa = mutableListOf<ProductItem>()

                for (i in productViewModel.pulsa) {
                    if (i.is_verified!! == "1") {
                        pulsa.add(i)
                    }
                }

                binding.vpTryout.adapter =
                    TabsProductAdapter(
                        supportFragmentManager,
                        Gson().toJson(list.toList()),
                        Gson().toJson(nomor.toList()),
                        Gson().toJson(item),
                        Gson().toJson(pulsa.toList()),
                        Gson().toJson(productViewModel.post),
                        Gson().toJson(productViewModel.bundling),
                        "",
                        false
                    )
                binding.tlTryout.setupWithViewPager(binding.vpTryout)

                binding.vpTryout.currentItem = when (type) {
                    "kuota" -> 0
                    "nomor_cantik" -> 1
                    "sales" -> 2
                    "pulsa" -> 3
                    "post_paid" -> 4
                    "bundling" -> 5
                    else -> 6
                }
            })
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.pbList.visibility = View.VISIBLE
        } else {
            binding.pbList.visibility = View.GONE
        }
    }
}