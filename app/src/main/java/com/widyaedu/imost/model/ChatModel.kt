package com.widyaedu.imost.model

data class ChatModel(
    val from_id: String = "",
    val judul: String = "",
    val deskripsi: String = "",
    val time: Any? = null,
    val file: String? = null
)