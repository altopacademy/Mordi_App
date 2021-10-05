package com.widyaedu.imost.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.widyaedu.imost.R
import com.widyaedu.imost.adapter.PaymentAdapter
import com.widyaedu.imost.databinding.ActivityCheckoutBinding
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.ui.PesanActivity.Companion.SALES_KEY
import com.widyaedu.imost.utils.Tools
import com.widyaedu.imost.viewmodel.ItemViewModel

class CheckoutActivity : AppCompatActivity() {
    companion object {
        const val IDProductCheckout = "EXTRA_ID"
        const val Quantity = "qty"
        const val id = "id"
        const val price = "price"
    }

    private lateinit var binding: ActivityCheckoutBinding
    private lateinit var productViewModel: ItemViewModel
    private lateinit var pref: PreferencesManager
    private var salesId: String = ""
    private var type: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = PreferencesManager(this)
        productViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)

        val productId = intent?.getStringExtra(IDProductCheckout)
        val qty = intent?.getStringExtra(Quantity)

        val price = intent?.getStringExtra(price)!!.toInt() * qty!!.toInt()
        val id = intent?.getStringExtra(id).toString()
        binding.tvTransfer.text =
            "Transfer sejumlah Rp. ${Tools.formatNumber(price.toString())} ke salah satu rekening di bawah ini"

        salesId = intent?.getStringExtra("id")!!
        productViewModel.getSalesId(salesId)

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.tvCOD.setOnClickListener {
            binding.tvTrf.background = ContextCompat.getDrawable(this, R.drawable.round_solid_gray)
            binding.tvTrf.setTextColor(ContextCompat.getColor(this, R.color.dg_gray))

            binding.tvCOD.background =
                ContextCompat.getDrawable(this, R.drawable.round_solid_yellow)
            binding.tvCOD.setTextColor(ContextCompat.getColor(this, R.color.white))

            binding.tvCODs.visibility = VISIBLE
            binding.llTrf.visibility = GONE
            type = "cod"
        }
        binding.tvTrf.setOnClickListener {
            binding.tvCOD.background = ContextCompat.getDrawable(this, R.drawable.round_solid_gray)
            binding.tvCOD.setTextColor(ContextCompat.getColor(this, R.color.dg_gray))

            binding.tvTrf.background =
                ContextCompat.getDrawable(this, R.drawable.round_solid_yellow)
            binding.tvTrf.setTextColor(ContextCompat.getColor(this, R.color.white))

            binding.llTrf.visibility = VISIBLE
            binding.tvCODs.visibility = GONE
            type = "transfer"
        }
        binding.bt.setOnClickListener {
            addTransaction(productId.toString(), pref.getUser(), qty.toString(), type)
        }
        productViewModel.salesInfo.observe(this, {
            showPaymentlist(it.user_id.toString(), it.name.toString())
        })
        productViewModel.newTransact.observe(this, {
            val i = Intent(this, PesanActivity::class.java).apply {
                putExtra(SALES_KEY, salesId)
            }
            startActivity(i)
        })
    }

    private fun addTransaction(productId: String, userId: String, qty: String, type: String) {
        Tools.getSnackLong("loading...", binding.root).show()
        productViewModel.addTransaction(productId, userId, qty, type) {}
    }

    private fun showPaymentlist(userId: String, nama: String) {
        productViewModel.listMyPayment(userId)
        productViewModel.listPayment.observe(this, {
            if (it.status == 0) {
                binding.rvListPayment.visibility = View.GONE
                binding.tvNamaRekening.text = "Sales Ini belum punya rekening"
            } else {
                binding.tvNamaRekening.text = "Nama pemilik rekening: ${nama}"
                binding.rvListPayment.adapter = PaymentAdapter(it.data)
                binding.rvListPayment.layoutManager = LinearLayoutManager(this)
            }

        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, HomeActivity::class.java))
    }
}