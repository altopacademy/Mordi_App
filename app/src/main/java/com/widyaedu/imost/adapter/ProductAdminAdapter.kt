package com.widyaedu.imost.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.widyaedu.imost.R
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.ui.product.DetailProductActivity
import com.widyaedu.imost.utils.Tools
import kotlinx.android.synthetic.main.item_adminkuota.view.*

class ProductAdminAdapter(private val item: List<ProductItem>) :
    RecyclerView.Adapter<ProductAdminAdapter.ProductHolder>() {

    class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setupView(product: ProductItem?) {
            itemView.productNameAdmin.text = product?.product_name
            itemView.productDetailAdmin.text = product?.description
            itemView.salesNameAdmin.text = product?.user_name
            itemView.tvCityAdmin.text = product?.city
            itemView.priceAdmin.text = "Rp. ${Tools.formatNumber(product?.price!!)}"
            itemView.setOnClickListener {
                val i = Intent(it.context, DetailProductActivity::class.java).apply {
                    putExtra(DetailProductActivity.IDProduct, product.product_details_id)
                }
                it.context.startActivity(i)

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder =
        ProductHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_adminkuota, parent, false)
        )

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.setupView(item[position])
    }

    override fun getItemCount(): Int = item.size
}