package com.widyaedu.imost.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.widyaedu.imost.adapter.ProductAdapter
import com.widyaedu.imost.adapter.RatingAdapter
import com.widyaedu.imost.databinding.ActivitySalesBinding
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.model.RatingModel
import com.widyaedu.imost.model.Sales
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.viewmodel.ItemViewModel

class SalesActivity : AppCompatActivity() {
    companion object {
        const val SALES_ID = "extra_sales"
    }

    private lateinit var binding: ActivitySalesBinding
    private lateinit var userViewModel: ItemViewModel
    private lateinit var pref: PreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySalesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userId = intent?.getStringExtra(SALES_ID)
        binding.ivBack.setOnClickListener { onBackPressed() }
        pref = PreferencesManager(this)
        userViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)
        userViewModel.getSalesId(userId.toString())

        userViewModel.listRating(userId.toString())
        userViewModel.getMyproduct("post_paid", userId.toString(), "Sales")
        userViewModel.productItem.observe(this, {
            showSalesProduct(it)
        })
        userViewModel.salesInfo.observe(this, {
            showSalesInfo(it)
        })
        userViewModel.listrating.observe(this, {

            showRating(it)
        })
        binding.tvKuota.setOnClickListener {
            userViewModel.getMyproduct("kuota", userId.toString(), "Sales")
            userViewModel.productItem.observe(this, {
                showSalesProduct(it)
            })
        }

        binding.tvNomor.setOnClickListener {
            userViewModel.getMyproduct("nomor_cantik", userId.toString(), "Sales")
            userViewModel.productItem.observe(this, {
                showSalesProduct(it)
            })
        }

        binding.tvPulsa.setOnClickListener {
            userViewModel.getMyproduct("pulsa", userId.toString(), "Sales")
            userViewModel.productItem.observe(this, {
                showSalesProduct(it)
            })
        }

        binding.tvPost.setOnClickListener {

        }

        binding.tvBundlind.setOnClickListener {
            userViewModel.getMyproduct("bundling", userId.toString(), "Sales")
            userViewModel.productItem.observe(this, {
                showSalesProduct(it)
            })
        }
    }

    private fun showSalesProduct(itemList: List<ProductItem>){
        binding.rvProductSales.adapter = ProductAdapter(itemList)
        binding.rvProductSales.layoutManager = LinearLayoutManager(this)
    }

    private fun showRating(rating: List<RatingModel>){
        binding.rvratingsales.adapter = RatingAdapter(rating)
        binding.rvratingsales.layoutManager = LinearLayoutManager(this)
    }
    private fun showSalesInfo(sales: Sales?) {
        binding.ivRatingSales.rating = sales?.rating?.toFloat() ?: 0f
        if (sales?.rating.isNullOrEmpty()){
            binding.tvRate.text = "Belum Ada Penilaian"
        } else {
            binding.tvRate.text = "${sales?.rating}/5"
        }
        binding.tvSalesName.text = sales?.name
        binding.tvSalesLoc.text = sales?.city
        binding.tvSalesDesc.text = sales?.description
        Glide.with(this).load(sales?.photo).into(binding.imgSales)
    }


}