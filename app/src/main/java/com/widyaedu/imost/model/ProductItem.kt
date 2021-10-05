package com.widyaedu.imost.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductItem(
    val appleid: String? = null,
    val city: String? = null,
    val date_finish: String? = null,
    val date_start: String? = null,
    val email: String? = null,
    val phone_number: String? = null,
    var price: String? = null,
    val product_date_created: String? = null,
    val product_date_edited: String? = null,
    var description: String? = null,
    val product_is_deleted: String? = null,
    var product_name: String? = null,
    val product_photo: String? = null,
    val type: String? = null,
    val user_date_created: String? = null,
    val user_date_edited: String? = null,
    val user_description: String? = null,
    val user_is_deleted: String? = null,
    val user_name: String? = null,
    val user_photo: String? = null,
    val product_id: String? = null,
    var status: String? = null,

    //productmaster
    var product_details_id: String? = null,
    var user_id: String? = null,
    var date_created: String? = null,
    var date_edited: String? = null,
    var date_verified: String? = null,
    var is_verified: String? = null,
    var name: String? = null,
    var city_id: String? = null,
) : Parcelable