package com.widyaedu.imost.model

data class CityItem(
    val name: String,
    val city_id: String
) {
    override fun toString(): String = name
}