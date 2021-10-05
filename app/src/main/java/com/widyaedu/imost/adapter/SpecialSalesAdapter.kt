package com.widyaedu.imost.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.widyaedu.imost.R
import com.widyaedu.imost.model.Sales
import com.widyaedu.imost.ui.PesanActivity
import com.widyaedu.imost.ui.PesanActivity.Companion.SALES_KEY
import com.widyaedu.imost.utils.Tools
import kotlinx.android.synthetic.main.item_sales.view.*

class SpecialSalesAdapter(
    private val sales: List<Sales>?,
) :
    RecyclerView.Adapter<SpecialSalesAdapter.SalesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesHolder = SalesHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_sales, parent, false
        )
    )

    override fun onBindViewHolder(holder: SalesHolder, position: Int) {
        holder.setupView(sales?.get(position))
        holder.itemView.setOnClickListener {
            for (s in sales!!) {
                s.isSelected = false
            }
            sales[position].isSelected = true
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = sales?.size!!

    class SalesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setupView(sales: Sales?) {
            if (sales!!.isSelected) {
                itemView.clSales.setBackgroundColor(ContextCompat.getColor(itemView.context,
                    R.color.beige))
            } else {
                itemView.clSales.setBackgroundColor(ContextCompat.getColor(itemView.context,
                    R.color.white))
            }
            itemView.tvSales.text = sales.name
            itemView.tvSalesLokasi.text = sales.city
            itemView.ivRate.visibility = GONE

            Glide.with(itemView.context).load(sales.photo).override(
                Tools.getScreenX(itemView.context as Activity) / 5,
                Tools.getScreenX(itemView.context as Activity) / 5
            ).into(itemView.ivSales)

            itemView.ivChat.setOnClickListener {
                val i = Intent(it.context, PesanActivity::class.java).apply {
                    putExtra(SALES_KEY, sales.user_id)
                }
                it.context.startActivity(i)
            }

        }
    }
}