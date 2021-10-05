package com.widyaedu.imost.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.widyaedu.imost.adapter.ProductAdapter
import com.widyaedu.imost.databinding.ActivityListBinding
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.ui.product.ListProductActivity.Companion.PRODUCT_TYPE
import com.widyaedu.imost.viewmodel.ItemViewModel

class ListActivity : AppCompatActivity() {

    private val binding by lazy { ActivityListBinding.inflate(layoutInflater) }
    private lateinit var productViewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        productViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)

        productViewModel.getProduct(intent.getStringExtra(PRODUCT_TYPE)!!, "", "", "")

        binding.ivBack.setOnClickListener { onBackPressed() }

        when (intent.getStringExtra("type")) {
            "pulsa" -> binding.tvTitle.text = "Pulsa"
            "bundling" -> binding.tvTitle.text = "Bundling"
            else -> binding.tvTitle.text = "Post Paid"
        }

        productViewModel.producStatus.observe(this, { item ->
            if (item.data.isNullOrEmpty()) {
                binding.rvList.visibility = View.GONE
                binding.tvNodata.visibility = View.VISIBLE
            } else {
                binding.rvList.visibility = View.VISIBLE
                binding.tvNodata.visibility = View.GONE
                showItemProduct(item.data)
            }
        })
    }

    private fun showItemProduct(item: List<ProductItem>) {
        val list = mutableListOf<ProductItem>()
        for (i in item) {
            if (i.is_verified!! == "1") {
                list.add(i)
            }
        }

        binding.rvList.adapter = ProductAdapter(list.toList())
    }
}