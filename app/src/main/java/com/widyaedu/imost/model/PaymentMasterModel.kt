package com.widyaedu.imost.model

data class PaymentMasterModel(
    val date_created: String,
    val date_edited: String,
    val description: String,
    val is_deleted: String,
    val name: String,
    val payment_method_id: String,
    val photo: String,
)