package com.widyaedu.imost.model

data class Transaction(
    val customer_id: String?,
    val date_created: String?,
    val date_expired: String?,
    val date_finished: String?,
    val product_id: String?,
    val quantity: String?,
    val sales_id: String?,
    var status: String?,
    val total_price: String?,
    val transaction_id: String?,
    val user_id: String?,
    val product_name: String?,
    val type: String?,
    val product_type: String?,
    val transaction_number: String,
)