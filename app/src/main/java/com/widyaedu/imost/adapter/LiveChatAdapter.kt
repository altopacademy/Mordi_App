package com.widyaedu.imost.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.widyaedu.imost.R
import com.widyaedu.imost.model.ChatModel
import com.widyaedu.imost.utils.Tools

class LiveChatAdapter(
    options: FirestoreRecyclerOptions<ChatModel>,
    private val activity: Activity,
    private val url: String?
) :
    FirestoreRecyclerAdapter<ChatModel, LiveChatAdapter.ChatHolder>(options) {

    private val user = FirebaseAuth.getInstance().currentUser

    companion object {
        const val MSG_LEFT = 0
        const val MSG_RIGHT = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val view: View = if (viewType == MSG_RIGHT) {
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        } else {
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat_sales, parent, false)
        }
        val ch = ChatHolder(view)
        ch.ivImg.setOnClickListener {
            getItem(ch.adapterPosition).file?.let { pic ->
                Tools.showDialogZoom(
                    activity,
                    pic
                )
            }
        }

        return ch
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int, model: ChatModel) {
        holder.tvChat.text = model.deskripsi

        try {
            val date: Timestamp = model.time as Timestamp
            holder.tvDate.text = Tools.formatDateHours(date.toDate())
        } catch (e: Exception){}

        if (model.file != null) {
            holder.tvChat.visibility = GONE
            holder.ivImg.visibility = VISIBLE

            Glide.with(activity).load(model.file).apply(
                RequestOptions.overrideOf(
                    Tools.getScreenX(activity) / 2,
                    Tools.getScreenX(activity) / 2
                )
            ).into(holder.ivImg)
        } else {
            holder.tvChat.visibility = VISIBLE
            holder.ivImg.visibility = GONE
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).from_id == user?.uid)
            MSG_RIGHT
        else
            MSG_LEFT
    }

    class ChatHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvChat: TextView = itemView.findViewById(R.id.tvChat)
        var tvDate: TextView = itemView.findViewById(R.id.tvDate)
        var ivImg: ImageView = itemView.findViewById(R.id.ivImg)
    }
}