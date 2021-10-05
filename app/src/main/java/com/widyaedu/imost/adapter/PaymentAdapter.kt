package com.widyaedu.imost.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.widyaedu.imost.R
import com.widyaedu.imost.model.Payment
import kotlinx.android.synthetic.main.item_payment.view.*

class PaymentAdapter(private val listPay: List<Payment>): RecyclerView.Adapter<PaymentAdapter.PaymentListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentListHolder =
        PaymentListHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_payment, parent, false))

    override fun onBindViewHolder(holder: PaymentListHolder, position: Int) {
        val pos = holder.adapterPosition

        if (pos == 0){
            holder.itemView.apply {
                setHeaderBg(namaBank)
                setHeaderBg(noRek)

                namaBank.text = "Nama Bank"
                noRek.text = "No. Rekening"
            }
        } else {
            val item = listPay[pos - 1]
            holder.itemView.apply {
                setContentBg(namaBank)
                setContentBg(noRek)

                namaBank.text = item.name
                noRek.text = item.account_number
            }
        }
    }

    override fun getItemCount(): Int = listPay.size + 1

    class PaymentListHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun setView(payment: Payment){
            itemView.namaBank.text = payment.name
            itemView.noRek.text = payment.account_number
        }

    }

    private fun setHeaderBg(view: View) {
        view.setBackgroundResource(R.drawable.table_header_cell_bg)
    }

    private fun setContentBg(view: View) {
        view.setBackgroundResource(R.drawable.table_content_cell_bg)
    }
}