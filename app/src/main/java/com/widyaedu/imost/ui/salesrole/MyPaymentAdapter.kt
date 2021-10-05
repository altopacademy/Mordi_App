package com.widyaedu.imost.ui.salesrole

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.widyaedu.imost.R
import com.widyaedu.imost.model.Payment
import kotlinx.android.synthetic.main.item_mypayment.view.*

class MyPaymentAdapter(private var mypayment: List<Payment>) : RecyclerView.Adapter<MyPaymentAdapter.PaymentHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentHolder = PaymentHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_mypayment, parent, false)
    )

    override fun onBindViewHolder(holder: PaymentHolder, position: Int) {
        holder.setupView(mypayment[position])
    }

    override fun getItemCount(): Int = mypayment.size

    class PaymentHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun setupView(payment: Payment){
            itemView.paymentName.text = payment.name
            itemView.tvRekening.text = payment.account_number
            Glide.with(itemView.context).load(payment.photo).into(itemView.imgIconBank)
            itemView.setOnClickListener {
                val i = Intent(it.context, AddPayment::class.java).apply {
                    putExtra("edit", true)
                    putExtra("userid", payment.payment_method_details_id)
                }
                it.context.startActivity(i)
            }
        }
    }

    fun setData(list: List<Payment>){
        mypayment = list
        notifyDataSetChanged()
    }
}