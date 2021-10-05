package com.widyaedu.imost.adapter

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.widyaedu.imost.R
import com.widyaedu.imost.databinding.BottomAddPromoBinding
import com.widyaedu.imost.listener.ProductListener
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.ui.product.DetailProductActivity
import com.widyaedu.imost.utils.Tools
import kotlinx.android.synthetic.main.item_promo.view.*

class PromoAdapter(
    private val context: Activity,
    private val product: List<ProductItem>,
    private val listener: ProductListener? = null,
    val role: String? = null,
) :
    RecyclerView.Adapter<PromoAdapter.PromoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoHolder =
        PromoHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_promo, parent, false))

    override fun onBindViewHolder(holder: PromoHolder, position: Int) {
        holder.initView(product[position])
        if (role == "Sales") {
            holder.itemView.tvViewOption.setOnClickListener {
                val popup = PopupMenu(it.context, holder.itemView.tvViewOption)
                popup.inflate(R.menu.sales_option)
                popup.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.editSales -> {
                            showEdit(product[position])
                            true
                        }
                        R.id.deleteSales -> {
                            showDialog(product[position])
                            true
                        }
                        else -> false
                    }
                }
                popup.show()
            }
        } else {
            holder.itemView.tvViewOption.visibility = View.GONE
        }

    }

    override fun getItemCount(): Int = product.size
    inner class PromoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun initView(item: ProductItem?) {
            itemView.tvPromo.text = item?.product_name
            itemView.tvPromodesc.text = item?.description
            itemView.tvPromoLokasi.text = item?.city

            Glide.with(itemView.context)
                .load(item?.product_photo)
                .apply(RequestOptions.overrideOf(Tools.getScreenX(context) / 5,
                    Tools.getScreenX(context) / 5))
                .into(itemView.ivPromo)

            itemView.setOnClickListener {
                val i = Intent(it.context, DetailProductActivity::class.java).apply {
                    putExtra(DetailProductActivity.IDProduct, item?.product_details_id)
                }
                it.context.startActivity(i)
            }
        }
    }

    private fun showEdit(product: ProductItem) {
        val bindingEdit = BottomAddPromoBinding.inflate(context.layoutInflater)
        val dialog = BottomSheetDialog(context)
        dialog.setContentView(bindingEdit.root)

        bindingEdit.edtprodukName.setText(product.product_name)
        bindingEdit.edtprodukDescription.setText(product.description)
        bindingEdit.edtprodukPrice.setText(product.price)
        bindingEdit.btnUploadPhoto.visibility = View.GONE
        if (product.status == "Active") {
            bindingEdit.btnActive.setBackgroundColor(Color.GREEN)
            bindingEdit.btnActive.setTextColor(Color.WHITE)
        } else {
            bindingEdit.btnNonActive.setBackgroundColor(Color.RED)
            bindingEdit.btnNonActive.setTextColor(Color.WHITE)
        }
        bindingEdit.btnActive.setOnClickListener {
            product.status = "Active"
            bindingEdit.btnActive.setTextColor(Color.WHITE)
            bindingEdit.btnActive.background =
                ContextCompat.getDrawable(context, R.drawable.shape_btn_active_on)
            bindingEdit.btnNonActive.setTextColor(Color.RED)
            bindingEdit.btnNonActive.background =
                ContextCompat.getDrawable(context, R.drawable.shape_btn_nonactive_off)
        }

        bindingEdit.btnActive.setOnClickListener {
            product.status = "Inactive"
            bindingEdit.btnNonActive.setTextColor(Color.WHITE)
            bindingEdit.btnNonActive.background =
                ContextCompat.getDrawable(context, R.drawable.shape_btn_nonactive_on)
            bindingEdit.btnActive.setTextColor(Color.GREEN)
            bindingEdit.btnActive.background =
                ContextCompat.getDrawable(context, R.drawable.shape_btn_active_off)
        }
        bindingEdit.btnSaveProduk.setOnClickListener {
            val name = bindingEdit.edtprodukName.text.toString()
            val desc = bindingEdit.edtprodukDescription.text.toString()
            val price = bindingEdit.edtprodukPrice.text.toString()
            val data = ProductItem(product_name = name,
                price = price,
                description = desc,
                product_photo = product.product_photo,
                status = product.status,
                product_id = product.product_id)
            if (dialog.isShowing) {
                listener?.editProduct(data)
                dialog.dismiss()
            } else {
                dialog.show()
            }
        }
        dialog.show()
    }

    private fun showDialog(productItem: ProductItem) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Hapus Produk")
        builder.setMessage("Apakah Anda Ingin Mengahapus ${productItem.product_name}?")
        builder.setPositiveButton("YES") { dialog, which ->
            listener?.deleteProduct(productItem.product_id.toString())
        }

        builder.setNegativeButton("NO") { dialog, which ->
            builder.setCancelable(true)
        }

        builder.show()
    }
}