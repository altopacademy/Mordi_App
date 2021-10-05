package com.widyaedu.imost.adapter

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.widyaedu.imost.R
import com.widyaedu.imost.listener.SendStatus
import com.widyaedu.imost.model.RatingModel
import com.widyaedu.imost.model.Transaction
import com.widyaedu.imost.utils.Tools
import kotlinx.android.synthetic.main.bottom_confirm_transaction.view.*
import kotlinx.android.synthetic.main.dialog_rating.view.*
import kotlinx.android.synthetic.main.item_history_transaction.view.*

class TransactionAdapter(
    private val listener: SendStatus,
    private val item: List<Transaction>,
    val role: String,
) : RecyclerView.Adapter<TransactionAdapter.TransactionHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionHolder =
        TransactionHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history_transaction, parent, false))

    override fun onBindViewHolder(holder: TransactionHolder, position: Int) {
        holder.initView(item[position])
    }

    override fun getItemCount(): Int = item.size


    inner class TransactionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btmSheet =
            LayoutInflater.from(itemView.context).inflate(R.layout.bottom_confirm_transaction, null)
        val btmRating = LayoutInflater.from(itemView.context).inflate(R.layout.dialog_rating, null)
        val dialog = BottomSheetDialog(itemView.context)
        fun initView(transaction: Transaction?) {
            itemView.tvProduct.text = transaction?.product_name
            when (transaction?.product_type) {
                "kuota" -> {
                    itemView.tvType.text = "Kuota"
                    itemView.iv.setImageResource(R.drawable.ic_kuota)
                }
                "nomor_cantik" -> {
                    itemView.tvType.text = "Nomor Cantik"
                    itemView.iv.setImageResource(R.drawable.ic_nomor)
                }
                "pulsa" -> {
                    itemView.tvType.text = "Pulsa"
                    itemView.iv.setImageResource(R.drawable.ic_pulsa)
                }
                "post_paid" -> {
                    itemView.tvType.text = "Post Paid"
                    itemView.iv.setImageResource(R.drawable.ic_postpaid)
                }
                "bundling" -> {
                    itemView.tvType.text = "Bundling"
                    itemView.iv.setImageResource(R.drawable.ic_bundling)
                }
                else -> {
                    itemView.tvType.text = "Promo"
                    itemView.iv.setImageResource(R.drawable.ic_promo)
                }
            }

            if (transaction?.status == "Pending") {
                itemView.tvStatus2.visibility = View.VISIBLE
                itemView.tvStatus.visibility = View.INVISIBLE
                itemView.tvStatus2.text = transaction.status
            } else {
                itemView.tvStatus.text = transaction?.status
                itemView.tvStatus2.visibility = View.GONE
                itemView.tvStatus.visibility = View.VISIBLE
            }
            itemView.tvNomorTransaksi.text = "Nomor: ${transaction?.transaction_number}"
            itemView.tvPrice.text = "Rp. ${Tools.formatNumber(transaction?.total_price!!)}"
            itemView.tvDate.text = Tools.formatDate(transaction.date_created!!)

            if (role == "Sales") {
                if (transaction.status == "Berhasil") {
                    itemView.setOnClickListener {
                        Toast.makeText(it.context,
                            "Status Produk sudah diubah",
                            Toast.LENGTH_SHORT).show()
                    }
                } else {
                    itemView.setOnClickListener {
                        dialog.setContentView(btmSheet)
                        dialog.show()
                    }
                    btmSheet.productNameConfirm.text = transaction.product_name
                    btmSheet.tvPriceconfirm.text = transaction.total_price
                    btmSheet.btnConfirmYes.setOnClickListener {
                        if (dialog.isShowing) {
                            dialog.dismiss()
                            val data = transaction
                            listener.setStatus(data)
                            notifyDataSetChanged()
                        } else {
                            dialog.show()
                        }
                    }
                }
                itemView.tvRate.visibility = GONE
            } else {
                if (transaction.status == "Berhasil") {
                    itemView.tvRate.visibility = VISIBLE
                    itemView.tvRate.setOnClickListener {
                        dialog.setContentView(btmRating)
                        dialog.show()
                    }

                    itemView.setOnClickListener {
                        val d = Dialog(itemView.context, R.style.FullScreenDialog)
                        d.requestWindowFeature(Window.FEATURE_NO_TITLE)
                        d.setContentView(R.layout.popup_invoice)

                        val tanggal = d.findViewById<TextView>(R.id.tv3)
                        val name = d.findViewById<TextView>(R.id.tvNameproduk)
                        val trx = d.findViewById<TextView>(R.id.tvNomorTransaksi)
                        val price = d.findViewById<TextView>(R.id.tvPrice)
                        val type = d.findViewById<TextView>(R.id.tvType)
                        val sum = d.findViewById<TextView>(R.id.tvTotal)
                        val rlz = d.findViewById<ConstraintLayout>(R.id.rlZoom)

                        rlz.setOnClickListener { d.dismiss() }
                        tanggal.text = "Tanggal Order : ${transaction.date_created}"
                        name.text = transaction.product_name
                        trx.text = "No. Transaksi : ${transaction.transaction_number}"
                        price.text = "Rp. ${Tools.formatNumber(transaction.total_price)}"
                        type.text = transaction.type
                        sum.text = "Rp. ${Tools.formatNumber(transaction.total_price)}"

                        try {
                            d.show()
                        } catch (e: Exception) {
                        }
                    }

                    btmRating.btOK.setOnClickListener {
                        val rate = btmRating.ratingBar.rating
                        val note = btmRating.etInput.text.toString()
                        val name = transaction.product_name.toString()
                        val data = RatingModel(transaction_id = transaction.transaction_id,
                            name = name,
                            rating = rate.toString(),
                            notes = note,
                            user_id = transaction.user_id)

                        if (dialog.isShowing) {
                            listener.setData(data)
                            dialog.dismiss()
                        }
                    }
                } else {
                    itemView.tvRate.visibility = GONE
                    itemView.setOnClickListener {
                        Toast.makeText(it.context,
                            "Transaksi Masih Menunggu Konfirmasi",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}