package com.widyaedu.imost.ui.salesrole

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.Color.RED
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ListPopupWindow
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.widyaedu.imost.R
import com.widyaedu.imost.adapter.PromoAdapter
import com.widyaedu.imost.databinding.ActivityListMyProductBinding
import com.widyaedu.imost.databinding.BottomMenuAddProductBinding
import com.widyaedu.imost.databinding.BottomMenuAddProductNomorBinding
import com.widyaedu.imost.listener.ProductListener
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.model.ProductMaster
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.viewmodel.ItemViewModel

class ListMyProduct : AppCompatActivity(), ProductListener {
    companion object {
        const val PRODUCT_TYPE_ADD = "type"
    }

    private lateinit var binding: ActivityListMyProductBinding
    private lateinit var btmprodukBinding: BottomMenuAddProductBinding
    private val btmNomorBinding by lazy {
        BottomMenuAddProductNomorBinding.inflate(layoutInflater)
    }

    private lateinit var dialog: BottomSheetDialog
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var pref: PreferencesManager
    private var listMyProduct = mutableListOf<ProductItem>()
    private var filePath: Uri? = null
    private var firebaseStore: FirebaseStorage? = null
    private var storageReference: StorageReference? = null
    private var status = ""
    private var type = ""
    private var id = ""
    private val listPopupView by lazy { ListPopupWindow(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMyProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)

        btmprodukBinding = BottomMenuAddProductBinding.inflate(layoutInflater)

        dialog = BottomSheetDialog(this)
        pref = PreferencesManager(this)

        firebaseStore = FirebaseStorage.getInstance()
        storageReference = FirebaseStorage.getInstance().reference

        type = intent?.getStringExtra(PRODUCT_TYPE_ADD).toString()

        showLoading(true)

        getProduct()
        itemViewModel.getProductMaster(type)
        itemViewModel.productListMaster.observe(this, {
            if (it.isNullOrEmpty()) {
                showLoading(false)
            } else {
                initPopupList(
                    it,
                    btmprodukBinding.tvProduct
                )
            }
        })
        itemViewModel.productDetail.observe(this, {
            getProduct()
        })
        itemViewModel.productMaster.observe(this, {
            addProduct(pref.getUser(),
                type,
                it.product_id!!,
                btmNomorBinding.etHarga.text.toString(),
                status)
        })

        showBottom(type)
        goback()
        getType(type)
    }

    private fun getProduct() {
        itemViewModel.getMyproduct(type, pref.getUser(), pref.getRole())
    }

    private fun initPopupList(list: List<ProductMaster>, view: TextView) {
        listPopupView.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, list))
        listPopupView.setOnItemClickListener { _, _, position, _ ->
            view.text = list[position].name
            id = list[position].product_id!!
            listPopupView.dismiss()
        }
        listPopupView.anchorView = view
        view.setOnClickListener { listPopupView.show() }
    }

    private lateinit var adapterProduct: MyProductAdapter
    private lateinit var adapterPromo: PromoAdapter

    private fun showMyProduct(item: List<ProductItem>) {
        adapterProduct = MyProductAdapter(item, this)
        binding.rvMyproduct.adapter = adapterProduct
        binding.rvMyproduct.layoutManager = LinearLayoutManager(this)
    }

    private fun showPromo(item: List<ProductItem>) {
        adapterPromo = PromoAdapter(this, item, this)
        binding.rvMyproduct.adapter = adapterPromo
        binding.rvMyproduct.layoutManager = LinearLayoutManager(this)
    }

    private fun getType(type: String?) {
        if (type == "promo") {
            itemViewModel.productItem.observe(this, { item ->
                if (item != null) {
                    listMyProduct.addAll(item)
                    showPromo(item)
                    showLoading(false)
                }

            })

        } else {
            itemViewModel.productItem.observe(this, { item ->
                if (item != null) {
                    listMyProduct.addAll(item)
                    showMyProduct(item)
                    showLoading(false)
                }
            })
        }
    }

    private fun goback() {
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showBottom(type: String?) {
        binding.btnAddproduk.setOnClickListener {
            btmprodukBinding.btActive.setOnClickListener {
                status = "Active"
                btmprodukBinding.btActive.setTextColor(Color.WHITE)
                btmprodukBinding.btActive.background =
                    ContextCompat.getDrawable(this, R.drawable.shape_btn_active_on)
                btmprodukBinding.btNonActive.setTextColor(RED)
                btmprodukBinding.btNonActive.background =
                    ContextCompat.getDrawable(this, R.drawable.shape_btn_nonactive_off)
            }

            btmprodukBinding.btNonActive.setOnClickListener {
                status = "Inactive"
                btmprodukBinding.btNonActive.setTextColor(Color.WHITE)
                btmprodukBinding.btNonActive.background =
                    ContextCompat.getDrawable(this, R.drawable.shape_btn_nonactive_on)
                btmprodukBinding.btActive.setTextColor(ContextCompat.getColor(this, R.color.green))
                btmprodukBinding.btActive.background =
                    ContextCompat.getDrawable(this, R.drawable.shape_btn_active_off)
            }

            btmprodukBinding.btSaveProduk.setOnClickListener {
                addProduct(pref.getUser(),
                    type.toString(),
                    id,
                    btmprodukBinding.etHarga.text.toString(),
                    status)

                if (dialog.isShowing) {
                    Toast.makeText(this, "Anda Menambahkan produk", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                } else {
                    dialog.show()
                }
            }

            btmNomorBinding.btActive.setOnClickListener {
                status = "Active"
                btmNomorBinding.btActive.setTextColor(Color.WHITE)
                btmNomorBinding.btActive.background =
                    ContextCompat.getDrawable(this, R.drawable.shape_btn_active_on)
                btmNomorBinding.btNonActive.setTextColor(RED)
                btmNomorBinding.btNonActive.background =
                    ContextCompat.getDrawable(this, R.drawable.shape_btn_nonactive_off)
            }

            btmNomorBinding.btNonActive.setOnClickListener {
                status = "Inactive"
                btmNomorBinding.btNonActive.setTextColor(Color.WHITE)
                btmNomorBinding.btNonActive.background =
                    ContextCompat.getDrawable(this, R.drawable.shape_btn_nonactive_on)
                btmNomorBinding.btActive.setTextColor(ContextCompat.getColor(this, R.color.green))
                btmNomorBinding.btActive.background =
                    ContextCompat.getDrawable(this, R.drawable.shape_btn_active_off)
            }

            btmNomorBinding.btSaveProduk.setOnClickListener {

                addProductMaster(
                    type.toString(),
                    btmNomorBinding.etProduct.text.toString(),
                    btmNomorBinding.etDetail.text.toString(),
                    btmNomorBinding.etHarga.text.toString(),
                )

                if (dialog.isShowing) {
                    Toast.makeText(this, "Anda Menambahkan produk", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                } else {
                    dialog.show()
                }
            }

            dialog.setContentView(
                if (type == "nomor_cantik") {
                    btmNomorBinding.root
                } else {
                    btmprodukBinding.root
                }
            )

            dialog.show()
        }
    }

    private fun addProduct(
        userId: String,
        type: String,
        id: String,
        price: String,
        state: String,
        photo: String = "",
        name: String = "",
        description: String = "",
    ) {
        itemViewModel.addProduct(userId, type, id, price, state, photo, name, description)
    }

    private fun addProductMaster(
        type: String,
        name: String,
        description: String,
        price: String,
        photo: String = "",
    ) {
        itemViewModel.addProductMaster(type, price, photo, name, description)
    }


    override fun editProduct(product: ProductItem) {
        val bindingEdit = BottomMenuAddProductBinding.inflate(layoutInflater)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(bindingEdit.root)

        bindingEdit.tvProduct.text = product.product_name
        bindingEdit.etHarga.hint = product.price
        bindingEdit.tvProduct.setCompoundDrawables(null, null, null, null)


        if (product.status == "Active") {
            bindingEdit.btActive.setTextColor(Color.WHITE)
            bindingEdit.btActive.background =
                ContextCompat.getDrawable(this, R.drawable.shape_btn_active_on)
        } else {
            bindingEdit.btNonActive.setTextColor(Color.WHITE)
            bindingEdit.btNonActive.background =
                ContextCompat.getDrawable(this, R.drawable.shape_btn_nonactive_on)
        }

        bindingEdit.btActive.setOnClickListener {
            product.status = "Active"
            bindingEdit.btActive.setTextColor(Color.WHITE)
            bindingEdit.btActive.background =
                ContextCompat.getDrawable(this, R.drawable.shape_btn_active_on)
            bindingEdit.btNonActive.setTextColor(RED)
            bindingEdit.btNonActive.background =
                ContextCompat.getDrawable(this, R.drawable.shape_btn_nonactive_off)
        }

        bindingEdit.btNonActive.setOnClickListener {
            product.status = "Inactive"
            bindingEdit.btNonActive.setTextColor(Color.WHITE)
            bindingEdit.btNonActive.background =
                ContextCompat.getDrawable(this, R.drawable.shape_btn_nonactive_on)
            bindingEdit.btActive.setTextColor(ContextCompat.getColor(this, R.color.green))
            bindingEdit.btActive.background =
                ContextCompat.getDrawable(this, R.drawable.shape_btn_active_off)
        }

        bindingEdit.btSaveProduk.setOnClickListener {
            val price = if (bindingEdit.etHarga.text.toString().isBlank()) {
                bindingEdit.etHarga.hint.toString()
            } else {
                bindingEdit.etHarga.text.toString()
            }
            val data = ProductItem(product_name = product.product_name,
                price = price,
                description = "",
                product_photo = product.product_photo,
                status = product.status,
                product_id = product.product_details_id)
            if (dialog.isShowing) {
                saveEdit(data)
                dialog.dismiss()
                adapterProduct.notifyDataSetChanged()
            } else {
                dialog.show()
            }
        }
        dialog.show()
    }

    private fun saveEdit(product: ProductItem) {
        itemViewModel.updateProduct(product.product_id.toString(),
            type,
            product.price.toString(),
            product.status.toString())
        itemViewModel.getMyproduct(type, pref.getUser(), pref.getRole())
        itemViewModel.productItem.observe(this, {
            if (it != null) {
                listMyProduct.addAll(it)
                showLoading(false)
            }
        })
    }

    override fun deleteProduct(productId: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Hapus Produk")
        builder.setMessage("Apakah Anda Ingin Mengahapus?")
        builder.setPositiveButton("YES") { _, _ ->
            delete(productId)
        }

        builder.setNegativeButton("NO") { _, _ ->
            builder.setCancelable(true)
        }

        builder.show()
    }

    private fun delete(id: String) {
        itemViewModel.delete(id)
        itemViewModel.getMyproduct(type, pref.getUser(), pref.getRole())
        itemViewModel.productItem.observe(this, {
            if (it != null) {
                listMyProduct.addAll(it)
                showLoading(false)
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.pbMyProduct.visibility = View.VISIBLE
        } else {
            binding.pbMyProduct.visibility = View.GONE
        }
    }
}