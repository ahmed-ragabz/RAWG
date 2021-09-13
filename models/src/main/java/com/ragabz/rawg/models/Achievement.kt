package com.ragabz.rawg.models


import com.squareup.moshi.Json

data class Achievement(
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "percent")
    val percent: String
)