package com.widyaedu.imost.utils

import android.app.Activity
import android.app.Dialog
import android.util.DisplayMetrics
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.widyaedu.imost.R
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

object Tools {

    fun showDialogCustom(activity: Activity, click: View.OnClickListener, string: String) {
        val dialogView: View = activity.layoutInflater.inflate(R.layout.dialog_button, null)
        val dialog = BottomSheetDialog(activity)
        dialog.setContentView(dialogView)
        dialog.setCancelable(false)

        val msg: TextView? = dialog.findViewById(R.id.tvMessage)
        val ok: Button? = dialog.findViewById(R.id.btOK)

        msg!!.text = string
        ok!!.setOnClickListener {
            dialog.dismiss()
            click.onClick(it)
        }

        try {
            dialog.show()
        } catch (e: Exception) {
        }
    }

    fun getSnackIndefinite(msg: String?, view: View): Snackbar {
        return Snackbar.make(view, msg!!, Snackbar.LENGTH_INDEFINITE)
    }

    fun getSnackLong(msg: String?, view: View): Snackbar {
        return Snackbar.make(view, msg!!, Snackbar.LENGTH_LONG)
    }

    fun getSnackShort(msg: String?, view: View): Snackbar {
        return Snackbar.make(view, msg!!, Snackbar.LENGTH_SHORT)
    }

    fun getScreenX(activity: Activity): Int {
        val displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }

    fun formatDateHours(date: Date): String {
        val format = SimpleDateFormat("dd-MM-yyyy hh:mm", Locale.US)
        return format.format(date)
    }

    fun formatNumber(number: String?): String? {
        val s = if (number.isNullOrBlank()) {
            "0"
        } else {
            number
        }
        val formatter = DecimalFormat("#,###,###")
        return formatter.format(s.toDouble())
    }

    fun formatDate(date: String): String {
        val format = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.US)
        val d = format.parse(date)
        val f = SimpleDateFormat("dd-MM-yyyy", Locale.US)
        return f.format(d)
    }

    fun showDialogZoom(activity: Activity, url: String) {
        val dialog = Dialog(activity, R.style.FullScreenDialog)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.popup_zoom_image)
        val ivPic: PhotoView = dialog.findViewById(R.id.ivPic)
        val iv: ImageView = dialog.findViewById(R.id.ivClose)
        val rlZoom: ConstraintLayout = dialog.findViewById(R.id.rlZoom)

        Glide.with(activity)
            .load(url)
            .placeholder(R.mipmap.ic_launcher_round)
            .into(ivPic)

        rlZoom.setOnClickListener { dialog.dismiss() }
        iv.setOnClickListener { dialog.dismiss() }

        try {
            dialog.show()
        } catch (e: Exception) {
        }
    }

}