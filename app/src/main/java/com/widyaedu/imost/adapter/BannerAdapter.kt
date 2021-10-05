package com.widyaedu.imost.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.widyaedu.imost.R
import com.widyaedu.imost.model.BannerModel
import com.widyaedu.imost.utils.Tools

class BannerAdapter(private val banner: List<BannerModel>, private val context: Context) :
    PagerAdapter() {

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imgLayout =
            LayoutInflater.from(context).inflate(R.layout.item_image_promo, container, false)!!
        val imageUrl = banner[position].photo
        val imgItem = imgLayout.findViewById<ImageView>(R.id.img_item)
        Glide.with(context).load(imageUrl).into(imgItem)

        imgLayout.setOnClickListener { Tools.showDialogZoom(context as Activity, imageUrl) }

        container.addView(imgLayout, 0)

        return imgLayout
    }

    override fun getCount(): Int = banner.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
}