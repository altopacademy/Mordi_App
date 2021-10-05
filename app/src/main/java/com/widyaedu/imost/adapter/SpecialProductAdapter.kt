package com.widyaedu.imost.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.widyaedu.imost.R
import com.widyaedu.imost.model.ProductMaster
import com.widyaedu.imost.ui.DetailActivity
import com.widyaedu.imost.utils.Tools
import kotlinx.android.synthetic.main.item_kuota.view.*

class SpecialProductAdapter(
    private val activity: Activity,
    private val product: List<ProductMaster>,
) :
    RecyclerView.Adapter<SpecialProductAdapter.ProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder =
        ProductHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_kuota, parent, false)
        )

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.setupView(product[position], activity)
    }

    override fun getItemCount(): Int = product.size
    class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setupView(product: ProductMaster, activity: Activity) {
            itemView.tvCity.visibility = GONE
            itemView.salesName.visibility = GONE
            itemView.productName.text = product.name
            itemView.productDetail.text = product.description
            itemView.price.text = "Rp. ${Tools.formatNumber(product.price)}"

            Glide.with(itemView)
                .load(product.photo)
                .apply(RequestOptions.overrideOf(Tools.getScreenX(itemView.context as Activity) / 5))
                .into(itemView.ivIcon)

            itemView.setOnClickListener {
                activity.startActivity(Intent(activity, DetailActivity::class.java).apply {
                    putExtra("id", product.product_id)
                    putExtra("type", product.type)
                })
            }
        }
    }
}
