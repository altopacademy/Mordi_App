package com.widyaedu.imost.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("status")
    val status: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: T
)