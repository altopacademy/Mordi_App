package com.widyaedu.imost.adapter

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.widyaedu.imost.R
import com.widyaedu.imost.model.Sales
import com.widyaedu.imost.services.DeleteSales
import com.widyaedu.imost.ui.PesanActivity
import com.widyaedu.imost.ui.PesanActivity.Companion.SALES_KEY
import com.widyaedu.imost.ui.SalesActivity
import com.widyaedu.imost.ui.SalesActivity.Companion.SALES_ID
import com.widyaedu.imost.ui.adminrole.DetailSales
import com.widyaedu.imost.ui.adminrole.DetailSales.Companion.SALESID
import com.widyaedu.imost.utils.Tools
import kotlinx.android.synthetic.main.bottom_edit_sales.view.*
import kotlinx.android.synthetic.main.item_sales.view.*

class SalesAdapter(private val context: Context, private val sales: List<Sales>?, private val roles: String, private val listener: DeleteSales? =null) :
    RecyclerView.Adapter<SalesAdapter.SalesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesHolder = SalesHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_sales, parent, false
        )
    )

    override fun onBindViewHolder(holder: SalesHolder, position: Int) {
        holder.setupView(sales?.get(position))
        if (roles == "Admin") {
            holder.itemView.ivChat.visibility = View.GONE
            holder.itemView.tvViewOption.visibility = View.VISIBLE
            holder.itemView.tvViewOption.setOnClickListener {
                val popup = PopupMenu(it.context, holder.itemView.tvViewOption)
                popup.inflate(R.menu.sales_option)
                popup.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.editSales -> {
                            showBottomEdit(sales?.get(position)!!)
                            true
                        }
                        R.id.deleteSales -> {
                            showDialog(sales!![position])
                            true
                        }
                        else -> false
                    }
                }
                popup.show()
            }
            holder.itemView.setOnClickListener {
                val i = Intent(it.context, DetailSales::class.java).apply {
                    putExtra(SALESID, sales?.get(position)?.user_id)
                }
                it.context.startActivity(i)

            }
        } else {
            holder.itemView.setOnClickListener {
                val i = Intent(it.context, SalesActivity::class.java).apply {
                    putExtra(SALES_ID, sales?.get(position)?.user_id)
                }
                it.context.startActivity(i)
            }
        }
    }
    override fun getItemCount(): Int = sales?.size!!

    class SalesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setupView(sales: Sales?) {
            itemView.tvSales.text = sales?.name
            itemView.tvSalesLokasi.text = sales?.city
            itemView.ivRate.rating = sales?.rating?.toFloat() ?: 0f
            Glide.with(itemView.context).load(sales?.photo).override(
                Tools.getScreenX(itemView.context as Activity) / 5,
                Tools.getScreenX(itemView.context as Activity) / 5
            ).into(itemView.ivSales)

            itemView.ivChat.setOnClickListener {
                val i = Intent(it.context, PesanActivity::class.java).apply {
                    putExtra(SALES_KEY, sales?.user_id)
                }
                it.context.startActivity(i)
            }

        }
    }

    private fun showBottomEdit(sales: Sales) {
        val btmedit = LayoutInflater.from(context).inflate(R.layout.bottom_edit_sales, null)
        val dialog = BottomSheetDialog(context)
        btmedit.edtSalesDesc.setText(sales.description)
        btmedit.btnSaveSales.setOnClickListener {
            val desc = btmedit.edtSalesDesc.text.toString()
            val data = Sales(user_id = sales.user_id, city_id = sales.city_id ,
                description = desc, email = sales.email, name = sales.name, photo = sales.photo)
            if (dialog.isShowing){
                listener?.editSales(data)
                dialog.dismiss()
            } else {
                dialog.show()
            }
        }
        dialog.setContentView(btmedit)
        dialog.show()

    }
    private fun showDialog(sales: Sales){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Exit Aplication")
        builder.setMessage("Apakah Anda Ingin Mengahapus ${sales.name}?")
        builder.setPositiveButton("YES") { dialog, which ->
            listener?.deleteSales(sales)
        }

        builder.setNegativeButton("NO") { dialog, which ->
            builder.setCancelable(true)
        }

        builder.show()
    }

}