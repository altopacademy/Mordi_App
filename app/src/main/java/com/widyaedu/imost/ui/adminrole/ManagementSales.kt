package com.widyaedu.imost.ui.adminrole

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.toptoche.searchablespinnerlibrary.SearchableSpinner
import com.widyaedu.imost.R
import com.widyaedu.imost.adapter.SalesAdapter
import com.widyaedu.imost.databinding.ActivityManagementSalesBinding
import com.widyaedu.imost.databinding.BottomAddSalesBinding
import com.widyaedu.imost.model.CityItem
import com.widyaedu.imost.model.Sales
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.services.DeleteSales
import com.widyaedu.imost.viewmodel.ItemViewModel

class ManagementSales : AppCompatActivity(), DeleteSales{
    private lateinit var binding: ActivityManagementSalesBinding
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private var listCity = mutableListOf<CityItem>()
    private var listSales = mutableListOf<Sales>()
    private lateinit var cityId: String
    private lateinit var cityId2: String
    private lateinit var btmSheet: BottomAddSalesBinding
    private lateinit var myadapter: SalesAdapter
    private lateinit var searchableSpinner: SearchableSpinner
    private lateinit var pref: PreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManagementSalesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.sales_bar))
        title = ""
        bottomSheetDialog = BottomSheetDialog(this)
        searchableSpinner = SearchableSpinner(this)
        btmSheet = BottomAddSalesBinding.inflate(layoutInflater)
        pref = PreferencesManager(this)
        bottomSheetDialog.setContentView(btmSheet.root)
        itemViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            ItemViewModel::class.java
        )

        itemViewModel.getSales("", "")
        itemViewModel.sales.observe(this, {
            listSales.clear()
            listSales.addAll(it)
            myadapter.notifyDataSetChanged()
        })
        itemViewModel.getCityList()
        itemViewModel.cityItem.observe(this, {
            listCity.addAll(it)
            bottomSheet(it)
        })
        itemSales(listSales)
        back()
        showSpinner(listCity)
    }

    private fun itemSales(item: List<Sales>) {
        myadapter = SalesAdapter(this, item, pref.getRole(), this)
        binding.rvMySales.adapter = myadapter
        binding.rvMySales.layoutManager = LinearLayoutManager(applicationContext)

    }

    private fun bottomSheet(city: List<CityItem>) {
        binding.btnAddSales.setOnClickListener {
            //val btmsheet = layoutInflater.inflate(R.layout.bottom_sheet_addsales, null)
            bottomSheetDialog.show()
            btmSheet.spinnerAdd.adapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, city)
            btmSheet.spinnerAdd.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        val pos = btmSheet.spinnerAdd.selectedItemPosition
                        cityId = listCity[pos].city_id
                        //Log.d(getClassName(), "onItemSelected: $cityId")
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {

                    }

                }
            btmSheet.btnSaveSales.setOnClickListener {
                val nameSales = btmSheet.edtSalesName.text.toString()
                val email = btmSheet.edtSalesTele.text.toString()
                val desc = btmSheet.edtSalesDesc.text.toString()
                if (bottomSheetDialog.isShowing) {
                    addSales(email, nameSales, desc, cityId)
                    Toast.makeText(this, "Anda Menambah Sales", Toast.LENGTH_SHORT).show()
                    bottomSheetDialog.dismiss()
                    itemViewModel.getSales("", "")
                } else {
                    bottomSheetDialog.show()
                }

            }
        }
    }

    private fun addSales(email: String, name: String, cityId: String, desc: String) {
        itemViewModel.addSales(email, name, cityId, desc)
    }




    private fun showSpinner(itemCity: List<CityItem>) {
        binding.spinnerManageSales.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, itemCity)
        binding.spinnerManageSales.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    cityId2 = itemCity[p2].city_id
                    itemViewModel.getSales(cityId2, "")
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
    }

    private fun back() {
        binding.backSales.setOnClickListener {
            onBackPressed()
        }
    }

    override fun deleteSales(sales: Sales) {
        itemViewModel.deleteSales(sales.user_id.toString())
        itemViewModel.getSales("", "")
    }

    override fun editSales(sales: Sales) {
        itemViewModel.updateProfile(sales.user_id.toString(),
            sales.name.toString(), sales.description.toString(),
            sales.email.toString(), null, null, sales.photo.toString(), sales.city_id.toString())
        itemViewModel.getSales("", "")
    }

}