package com.widyaedu.imost.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.widyaedu.imost.R
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.ui.CheckoutActivity
import com.widyaedu.imost.utils.Tools
import kotlinx.android.synthetic.main.bottom_sheet_detail.view.*
import kotlinx.android.synthetic.main.item_kuota.view.*

class ProductAdapter(private val product: List<ProductItem>) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder =
        ProductHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_kuota, parent, false)
        )

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.setupView(product[position])
    }

    override fun getItemCount(): Int = product.size
    class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val btmsheet: View =
            LayoutInflater.from(itemView.context).inflate(R.layout.bottom_sheet_detail, null)
        val dialog = BottomSheetDialog(itemView.context)
        fun setupView(product: ProductItem?) {
            itemView.productName.text = product?.product_name
            itemView.productDetail.text = product?.description
            itemView.salesName.text = product?.user_name
            itemView.tvCity.text = product?.city
            itemView.price.text = "Rp. ${Tools.formatNumber(product!!.price)}"
            btmsheet.productNamesht.text = product.product_name
            btmsheet.tvPricesht.text = "Rp. ${Tools.formatNumber(product.price)}"
            btmsheet.productDetailsht.text = product.description
            btmsheet.salesNamesht.text = product.user_name
            Glide.with(itemView)
                .load(product.product_photo)
                .apply(RequestOptions.overrideOf(Tools.getScreenX(itemView.context as Activity) / 5))
                .into(itemView.ivIcon)

            Glide.with(itemView).load(product.product_photo).into(btmsheet.ivIconb)

            itemView.setOnClickListener {
                dialog.setContentView(btmsheet)
                dialog.show()
            }
            dialog.dismiss()

            btmsheet.btnBelisht.setOnClickListener {
                if (dialog.isShowing) {
                    dialog.dismiss()
                    val i = Intent(it.context, CheckoutActivity::class.java).apply {
                        putExtra(CheckoutActivity.IDProductCheckout, product.product_details_id)
                        putExtra(CheckoutActivity.Quantity, "1")
                        putExtra(CheckoutActivity.id, product.user_id)
                        putExtra(CheckoutActivity.price, product.price)
                    }
                    it.context.startActivity(i)
                } else {
                    dialog.show()
                }
            }
        }
    }
}
