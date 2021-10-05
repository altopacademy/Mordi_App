package com.widyaedu.imost.ui.adminrole

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.widyaedu.imost.R
import com.widyaedu.imost.databinding.ActivityDetailSalesBinding
import com.widyaedu.imost.databinding.BottomDatepickBinding
import com.widyaedu.imost.model.salesmodel.SalesAchiev
import com.widyaedu.imost.viewmodel.ItemViewModel
import java.text.SimpleDateFormat
import java.util.*


class DetailSales: AppCompatActivity() {
    companion object{
        const val SALESID = "SalesID"
    }
    private lateinit var binding: ActivityDetailSalesBinding
    private lateinit var btmDate: BottomDatepickBinding
    private lateinit var dialog: BottomSheetDialog
    private lateinit var itemViewModel: ItemViewModel
    private var mListener: DateData? = null
    private var salesId = ""
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSalesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dialog = BottomSheetDialog(this)
        btmDate = BottomDatepickBinding.inflate(layoutInflater)
        itemViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            ItemViewModel::class.java
        )
        salesId = intent.getStringExtra(SALESID).toString()
        itemViewModel.getSalesId(salesId)
        itemViewModel.salesInfo.observe(this, {
            binding.salesNameTv.text = it.name
            binding.salesDescTv.text = it.description
            Glide.with(this).load(it.photo).into(binding.salesImg)
        })
        showDate()
    }

//    private fun showList(item: List<ProductItem>){
//        binding.rvTransaction.adapter = ProductAdminAdapter(item)
//        binding.rvTransaction.layoutManager = LinearLayoutManager(this)
//    }
    /*private fun showProduct(salesId: String){
        binding.vpProductSales.adapter = ProductTabs(supportFragmentManager, salesId)
        binding.tabProduct.setupWithViewPager(binding.vpProductSales)
    }*/


    @RequiresApi(Build.VERSION_CODES.N)
    private fun showDate() {
        val days = Calendar.getInstance()
        val format = "yyyy-MM-dd"
        var start = ""
        var end = ""
        binding.cvShowDate.setOnClickListener {
            val datelistener = DatePickerDialog.OnDateSetListener { view, year, month, day ->
                R.style.MySpinnerDatePicker
                days.set(Calendar.YEAR, year)
                days.set(Calendar.MONTH, month)
                days.set(Calendar.DAY_OF_MONTH, day)
                val date = SimpleDateFormat(format, Locale.US).format(days.time)
                btmDate.spinnerDate.text = date
                start = "$date 00:00:00"
            }

            btmDate.spinnerDate.setOnClickListener {
                DatePickerDialog(this@DetailSales,
                    datelistener,
                    days.get(Calendar.YEAR),
                    days.get(Calendar.MONTH),
                    days.get(Calendar.DAY_OF_MONTH)).show()
            }

            val datelistener2 = DatePickerDialog.OnDateSetListener { view, year, month, day ->
                R.style.MySpinnerDatePicker
                days.set(Calendar.YEAR, year)
                days.set(Calendar.MONTH, month)
                days.set(Calendar.DAY_OF_MONTH, day)
                val date = SimpleDateFormat(format, Locale.US).format(days.time)
                btmDate.btnEndDate.text = date
                end = "$date 00:00:00"
            }
            btmDate.btnEndDate.setOnClickListener {
                DatePickerDialog(this@DetailSales,
                    datelistener2,
                    days.get(Calendar.YEAR),
                    days.get(Calendar.MONTH),
                    days.get(Calendar.DAY_OF_MONTH)).show()
            }
            btmDate.btnSetDate.setOnClickListener {
                if (dialog.isShowing){
                    getDateSales(start, end)
                    mListener?.date(salesId, start, end)
                    binding.cardView2.visibility = View.VISIBLE
                    dialog.dismiss()
                }
            }
            dialog.setContentView(btmDate.root)
            dialog.show()
        }
    }


    private fun getDateSales(start: String? = null, end: String? = null){
        itemViewModel.getSalesAchiev(salesId, start, end)
        itemViewModel.salesData.observe(this, { sales ->
            showGauge(sales)
        })
    }

    @SuppressLint("SetTextI18n")
    private fun showGauge(salesAchiev: SalesAchiev){
        binding.donut1.run {
            topText = "Kuota"
            bottomText = "10"
            initValue(salesAchiev.statistik?.total_kuota!!.toFloat(), 10f)
        }
        binding.donut1.setOnClickListener {
//            showList(salesAchiev.list?.kuota!!)
        }

        binding.donut2.run {
            topText = "Nomor\nCantik"
            bottomText = "10"
            initValue(salesAchiev.statistik?.total_nomor_cantik!!.toFloat(), 10f)
        }
        binding.donut2.setOnClickListener {
//            showList(salesAchiev.list?.nomor_cantik!!)
        }

        binding.donut3.run {
            topText = "Promo"
            bottomText = "10"
            initValue(salesAchiev.statistik?.total_program!!.toFloat(), 10f)
        }

        binding.donut3.setOnClickListener {
//            showList(salesAchiev.list?.program!!)
        }
        binding.totalPendapatan.text = "Total Pendapatan ${salesAchiev.statistik?.total_price}"
        //binding.donut1.updateValue(salesAchiev.statistik?.total_kuota?.toFloat()!!)
    }

    interface DateData{
        fun date(salesId: String, start: String, end: String)
    }

    fun setDate(listener: DateData){
        mListener = listener
    }


}