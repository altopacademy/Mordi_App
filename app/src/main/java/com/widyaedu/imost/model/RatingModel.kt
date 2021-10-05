package com.widyaedu.imost.model

data class RatingModel(
    var transaction_id: String?,
    var name: String?,
    var rating : String?,
    var user_id: String?,
    var notes: String?,
    var date_created: String?=null
)