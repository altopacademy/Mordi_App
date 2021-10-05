package com.widyaedu.imost.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.widyaedu.imost.R
import com.widyaedu.imost.model.RatingModel
import kotlinx.android.synthetic.main.item_review_sales.view.*

class RatingAdapter(private val list: List<RatingModel>): RecyclerView.Adapter<RatingAdapter.RatingHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_review_sales, parent, false)
        return RatingHolder(v)
    }

    override fun onBindViewHolder(holder: RatingHolder, position: Int) {
        holder.setupView(list[position])
    }

    override fun getItemCount(): Int = list.size

    class RatingHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun setupView(ratingModel: RatingModel){
            itemView.tvUserName.text = ratingModel.name
            itemView.tvNotes.text = ratingModel.notes
            itemView.ratingUser.rating = ratingModel.rating!!.toFloat()
            itemView.tvDateReview.text = ratingModel.date_created
        }

    }
}