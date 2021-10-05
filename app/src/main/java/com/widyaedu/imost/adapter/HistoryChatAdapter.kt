package com.widyaedu.imost.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.widyaedu.imost.R
import com.widyaedu.imost.model.ChatData
import com.widyaedu.imost.ui.PesanActivity
import com.widyaedu.imost.utils.Tools
import kotlinx.android.synthetic.main.item_history_chat.view.*

class HistoryChatAdapter(val context: Context, val item: List<ChatData>) :
    RecyclerView.Adapter<HistoryChatAdapter.ChatHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_history_chat, parent, false)
        val vh = ChatHolder(v)
        vh.itemView.setOnClickListener {
            val i = Intent(it.context, PesanActivity::class.java).apply {
                putExtra(PesanActivity.SALES_KEY, item[vh.adapterPosition].user_id)
                putExtra("name", item[vh.adapterPosition].name)
            }
            context.startActivity(i)
        }
        return vh
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        holder.setView(item[position])
    }

    override fun getItemCount(): Int = item.size

    class ChatHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setView(chat: ChatData) {
            itemView.tvNama.text = chat.name
            itemView.tvDate.text = Tools.formatDate(chat.date_created!!)
            Glide.with(itemView.context).load(chat.photo).into(itemView.iv)
        }
    }
}