package com.widyaedu.imost.model

data class ProductMaster(
    var date_created: String?,
    var date_edited: String?,
    var description: String?,
    var is_deleted: String?,
    var is_owned: String?,
    var name: String?,
    var product_id: String?,
    var photo: String?,
    var price: String?,
    var type: String?,
){
    override fun toString(): String = name.toString()
}