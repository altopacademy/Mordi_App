package com.widyaedu.imost.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.widyaedu.imost.adapter.SpecialSalesAdapter
import com.widyaedu.imost.databinding.ActivityDetailBinding
import com.widyaedu.imost.model.Sales
import com.widyaedu.imost.utils.Tools
import com.widyaedu.imost.viewmodel.ItemViewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var productViewModel: ItemViewModel

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        productViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)

        productViewModel.getProduct(
            intent.getStringExtra("type")!!,
            role = "",
            id = intent.getStringExtra("id")!!
        )

        productViewModel.getCityList()
        productViewModel.cityItem.observe(this, { data ->
            if (data != null) {
                val list = mutableListOf<String>()
                for (s in data) {
                    list.add(s.name)
                }

                binding.spinnerProduct.adapter =
                    ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
                binding.spinnerProduct.onItemSelectedListener =
                    object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long,
                        ) {
                            productViewModel.getProduct(
                                intent.getStringExtra("type")!!,
                                cityId = data[p2].city_id,
                                role = "",
                                id = intent.getStringExtra("id")!!
                            )
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }
            }
        })

        productViewModel.producStatus.observe(this, { item ->
            val product = item.data
            val sales = mutableListOf<Sales>()
            for (s in item.data) {
                sales.add(Sales(city = s.city,
                    city_id = s.city_id,
                    name = s.user_name,
                    user_id = s.user_id,
                    photo = s.user_photo))
            }

            if (product.isNotEmpty()) {
                binding.productNamesht.text = product[0].product_name
                binding.productDetailsht.text = product[0].description
                binding.tvPricesht.text = "Rp. ${Tools.formatNumber(product[0].price)}"
                Glide.with(this).load(product[0].product_photo).into(binding.ivIcon)
            }
            binding.rvSales.adapter = SpecialSalesAdapter(sales.toList())

            binding.btnBelisht.setOnClickListener {
                var pos = -1
                for (s in sales.indices) {
                    if (sales[s].isSelected) {
                        pos = s
                        break
                    }
                }
                if (pos == -1) {
                    Tools.getSnackShort("Pilih Sales terlebih dahulu", binding.root).show()
                    return@setOnClickListener
                }
                val i = Intent(it.context, CheckoutActivity::class.java).apply {
                    putExtra(CheckoutActivity.IDProductCheckout, product[pos].product_details_id)
                    putExtra(CheckoutActivity.Quantity, "1")
                    putExtra(CheckoutActivity.id, product[pos].user_id)
                    putExtra(CheckoutActivity.price, product[pos].price)
                }
                startActivity(i)
            }
        })
    }
}