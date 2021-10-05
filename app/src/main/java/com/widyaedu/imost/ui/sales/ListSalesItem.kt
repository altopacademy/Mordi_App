package com.widyaedu.imost.ui.sales

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.toptoche.searchablespinnerlibrary.SearchableSpinner
import com.widyaedu.imost.R
import com.widyaedu.imost.adapter.SalesAdapter
import com.widyaedu.imost.databinding.ActivityListSalesItemBinding
import com.widyaedu.imost.model.CityItem
import com.widyaedu.imost.model.Sales
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.ui.product.ListProductActivity
import com.widyaedu.imost.viewmodel.ItemViewModel

class ListSalesItem : AppCompatActivity() {
    private lateinit var binding: ActivityListSalesItemBinding
    private lateinit var productViewModel: ItemViewModel
    private lateinit var searchableSpinner: SearchableSpinner
    private lateinit var city_id: String
    private var listCity = mutableListOf<CityItem>()
    private lateinit var pref: PreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListSalesItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.appaSalesItem))
        searchableSpinner = SearchableSpinner(this)
        productViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)
        pref = PreferencesManager(this)
        productViewModel.getCityList()
        productViewModel.cityItem.observe(this, {
            listCity.addAll(it)
        })
        showLoading(true)
        productViewModel.getSales("", "")
        productViewModel.sales.observe(this, {
            if (it.isEmpty()) {
                Toast.makeText(this, "Tidak Ada Sales Di Lokasi Tersebut", Toast.LENGTH_SHORT)
                    .show()
                binding.rvSalesItem.visibility = View.GONE
            } else {
                binding.rvSalesItem.visibility = View.VISIBLE
                showLoading(false)
                showSales(it)
            }

        })
        title = ""
        showSpinner(listCity)
        back()
    }

    private fun showSales(sales: List<Sales>?) {
        binding.rvSalesItem.adapter = SalesAdapter(this, sales, pref.getRole())
        binding.rvSalesItem.layoutManager = LinearLayoutManager(applicationContext)
    }


    private fun showSpinner(itemCity: List<CityItem>) {
        binding.spinnerSales.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, itemCity)
        val type = intent?.getStringExtra(ListProductActivity.PRODUCT_TYPE)
        binding.spinnerSales.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                city_id = itemCity[p2].city_id
                productViewModel.getSales(city_id, "")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    private fun back() {
        binding.bckItem.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showLoading(state: Boolean){
        if (state){
            binding.pbSales.visibility = View.VISIBLE
        } else {
            binding.pbSales.visibility = View.GONE
        }
    }
}