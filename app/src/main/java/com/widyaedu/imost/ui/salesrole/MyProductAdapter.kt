package com.widyaedu.imost.ui.salesrole

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.widyaedu.imost.R
import com.widyaedu.imost.listener.ProductListener
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.ui.product.DetailProductActivity
import com.widyaedu.imost.utils.Tools
import kotlinx.android.synthetic.main.item_mykuota.view.*

class MyProductAdapter(
    private val product: List<ProductItem>,
    private val listener: ProductListener? = null,
) :
    RecyclerView.Adapter<MyProductAdapter.MyProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductHolder =
        MyProductHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_mykuota, parent, false)
        )

    override fun onBindViewHolder(holder: MyProductHolder, position: Int) {
        holder.setupView(product[position])
        holder.itemView.tvViewOption.setOnClickListener {
            val popup = PopupMenu(it.context, holder.itemView.tvViewOption)
            popup.inflate(R.menu.sales_option)
            popup.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.editSales -> {
                        listener?.editProduct(product[position])
                        true
                    }
                    R.id.deleteSales -> {
                        listener?.deleteProduct(product[position].product_details_id!!)
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }

    override fun getItemCount(): Int = product.size

    class MyProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setupView(product: ProductItem?) {
            itemView.myProductName.text = product?.product_name
            itemView.myProductDetail.text = product?.description
            if (product?.status == "Active") {
                itemView.ivStatus.setTextColor(Color.GREEN)
                itemView.ivStatus.text = product.status
            } else {
                itemView.ivStatus.setTextColor(Color.RED)
                itemView.ivStatus.text = product?.status
            }

            itemView.myprice.text = "Rp. ${Tools.formatNumber(product?.price!!)}"
            itemView.setOnClickListener {
                val i = Intent(it.context, DetailProductActivity::class.java).apply {
                    putExtra(DetailProductActivity.IDProduct, product.product_details_id)
                }
                it.context.startActivity(i)
            }
        }
    }
}