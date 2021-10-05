package com.widyaedu.imost.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.widyaedu.imost.R
import kotlinx.android.synthetic.main.item_chat.view.*

class ChatAdapter(private val context: Context, private val chat: List<String>) :
    RecyclerView.Adapter<ChatAdapter.ChatHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder =
        ChatHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false))

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        holder.chatView(chat[position])
    }

    override fun getItemCount(): Int = chat.size

    inner class ChatHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun chatView(chat: String) {
            itemView.tvChat.text = chat
        }
    }
}