package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrailerData(
    @field:Json(name = "max")
    val max: String,
    @field:Json(name = "480")
    val x480: String
)