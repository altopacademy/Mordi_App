package com.widyaedu.imost.ui.salesrole

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.widyaedu.imost.databinding.ActivityListMyPaymentBinding
import com.widyaedu.imost.model.Payment
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.ui.HomeActivity
import com.widyaedu.imost.viewmodel.ItemViewModel

class ListMyPayment : AppCompatActivity() {
    private lateinit var binding: ActivityListMyPaymentBinding
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var paymentAdapter: MyPaymentAdapter
    private lateinit var pref: PreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMyPaymentBinding.inflate(layoutInflater)
        pref = PreferencesManager(this)
        itemViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ItemViewModel::class.java)
        setContentView(binding.root)
        itemViewModel.listMyPayment(pref.getUser())
        showLoading(true)
        itemViewModel.listPayment.observe(this, {
            if (it.data.isEmpty()){
                showLoading(false)
                Toast.makeText(this, "Anda Belum Memiliki Metode Pembayaran", Toast.LENGTH_SHORT).show()
            } else {
                showMyPayment(it.data)
                showLoading(false)
            }

        })
        binding.btnAddpayment.setOnClickListener {
            startActivity(Intent(this, AddPayment::class.java).apply {
                putExtra("edit", false)
            })
        }

        binding.back.setOnClickListener {
            back()
        }
    }

    private fun showMyPayment(list: List<Payment>){
        binding.rvMypayment.apply {
            paymentAdapter = MyPaymentAdapter(list)
            adapter = paymentAdapter
            paymentAdapter.notifyDataSetChanged()
            layoutManager = LinearLayoutManager(this@ListMyPayment)
        }
    }

    private fun showLoading(state: Boolean){
        if (state){
            binding.pbPayment.visibility = View.VISIBLE
        } else {
            binding.pbPayment.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        itemViewModel.listPayment.observe(this, {
            showMyPayment(it.data)
            paymentAdapter.notifyDataSetChanged()
        })
    }
    private fun back() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}