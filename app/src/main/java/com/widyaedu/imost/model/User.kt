package com.widyaedu.imost.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("appleid")
    var appleid: String? = null,
    @SerializedName("city")
    var city: String? = null,
    @SerializedName("date_created")
    var date_created: String? = null,
    @SerializedName("date_edited")
    var date_edited: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("is_deleted")
    var is_deleted: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("phone_number")
    var phone_number: String? = null,
    @SerializedName("photo")
    var photo: String? = null,
    @SerializedName("role")
    var role: String? = null,
    @SerializedName("user_id")
    var user_id: String? = null,
    @SerializedName("city_id")
    var city_id: String? = null,
)