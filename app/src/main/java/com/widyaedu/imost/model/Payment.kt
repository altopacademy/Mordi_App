package com.widyaedu.imost.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Payment(
    val payment_method_id: String?,
    val payment_method_details_id: String?,
    val user_id: String?,
    val name: String?,
    val description: String?,
    val account_number: String?,
    val account_name: String?,
    val photo: String?,
): Parcelable