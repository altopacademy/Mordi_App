package com.widyaedu.imost.ui.product

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.widyaedu.imost.databinding.ActivityDetailProductBinding
import com.widyaedu.imost.databinding.BottomMenuAddProductBinding
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.ui.CheckoutActivity
import com.widyaedu.imost.utils.Tools
import com.widyaedu.imost.viewmodel.ItemViewModel

class DetailProductActivity : AppCompatActivity() {
    companion object {
        const val IDProduct = "EXTRA_ID"
    }

    private lateinit var pref: PreferencesManager
    private lateinit var productViewModel: ItemViewModel
    private lateinit var binding: ActivityDetailProductBinding
    private lateinit var btmprodukBinding: BottomMenuAddProductBinding
    private lateinit var dialog: BottomSheetDialog
    private var role = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        btmprodukBinding = BottomMenuAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dialog = BottomSheetDialog(this)
        val idProduct = intent?.getStringExtra(IDProduct)
        pref = PreferencesManager(this)
        role = pref.getRole()
        productViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)
        productViewModel.getDetailProduct(idProduct.toString())
        productViewModel.productDetail.observe(this, {
            showDetail(it)
        })
        hideBtn(role)

    }

    private fun showDetail(product: ProductItem?) {
        binding.productName.text = product?.product_name
        binding.productDetail.text = product?.description
        binding.salesName.text = product?.user_name
        binding.tvPrice.text = "Rp. ${Tools.formatNumber(product?.price!!)}"
        Glide.with(applicationContext).load(product.product_photo).into(binding.imgDetail)
        val qty = "1"
        binding.btnBeli.setOnClickListener {
            val i = Intent(this, CheckoutActivity::class.java).apply {
                putExtra(CheckoutActivity.IDProductCheckout, product.product_id)
                putExtra(CheckoutActivity.Quantity, qty)
                putExtra(CheckoutActivity.id, product.user_id)
                putExtra(CheckoutActivity.price, product.price)
            }
            startActivity(i)
        }
    }

    private fun hideBtn(role: String) {
        if (role == "Admin" || role == "Sales") {
            binding.btnBeli.visibility = View.GONE
            /*binding.btnEdit.visibility = View.VISIBLE
            binding.btnDelete.visibility = View.VISIBLE*/
        }
    }

    /*private fun showbtm(product: ProductItem?){
        binding.btnEdit.setOnClickListener {
            btmprodukBinding.etprodukName.setText(product?.product_name)
            btmprodukBinding.etprodukDescription.setText(product?.product_description)
            btmprodukBinding.etprodukPrice.setText(product?.price)
            if (product?.status == "Active"){
                btmprodukBinding.btActive.setBackgroundColor(GREEN)
            } else {
                btmprodukBinding.btActive.setBackgroundColor(GREEN)
            }
            dialog.setContentView(btmprodukBinding.root)
            dialog.show()
        }
    }

    private fun updete(product_id: String){
        var status = ""
        btmprodukBinding.btActive.setOnClickListener {
            status = "Active"
            btmprodukBinding.btActive.setBackgroundColor(GREEN)
            btmprodukBinding.btNonActive.setBackgroundColor(TRANSPARENT)
            btmprodukBinding.btNonActive.isEnabled = false
        }

        btmprodukBinding.btNonActive.setOnClickListener {
            status = "Inactive"
            btmprodukBinding.btActive.isEnabled = false
            btmprodukBinding.btNonActive.setBackgroundColor(RED)
            btmprodukBinding.btActive.setBackgroundColor(TRANSPARENT)

        }
        btmprodukBinding.btSaveProduk.setOnClickListener {
            val nameedit = btmprodukBinding.etprodukName.text.toString()
            val descedit = btmprodukBinding.etprodukDescription.text.toString()
            val pricedit = btmprodukBinding.etprodukPrice.text.toString()

            if (dialog.isShowing){
                productViewModel.updateProduct(product_id, nameedit, descedit, pricedit, "", status)
                dialog.dismiss()
            }
        }

    }

    private fun delete(product_id: String){
        binding.btnDelete.setOnClickListener {
            productViewModel.delete(product_id)
            finish()
        }

    }*/

}