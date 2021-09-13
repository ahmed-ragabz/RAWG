package com.ragabz.rawg.models


import com.squareup.moshi.Json

data class TrailerData(
    @Json(name = "max")
    val max: String,
    @Json(name = "480")
    val x480: String
)