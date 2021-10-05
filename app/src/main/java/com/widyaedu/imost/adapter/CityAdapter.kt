package com.widyaedu.imost.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.widyaedu.imost.R
import com.widyaedu.imost.model.CityItem

class CityAdapter(val context: Context, val item: List<CityItem>) : BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = item.size

    override fun getItem(p0: Int): Any = item[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View
        val vh: ItemHolder
        if (p1 == null) {
            view = inflater.inflate(R.layout.custom_spinner, p2, false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = p1
            vh = view.tag as ItemHolder
        }
        vh.label.text = item[p0].name
        return view
    }

    private class ItemHolder(row: View?) {
        val label: TextView
        val img: ImageView

        init {
            label = row?.findViewById(R.id.tvLoc) as TextView
            img = row?.findViewById(R.id.imgIcon) as ImageView
        }
    }
}