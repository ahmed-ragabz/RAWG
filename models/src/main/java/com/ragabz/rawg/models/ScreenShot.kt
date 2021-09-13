package com.ragabz.rawg.models


import com.squareup.moshi.Json

data class ScreenShot(
    @Json(name = "hidden")
    val hidden: Boolean,
    @Json(name = "image")
    val image: String
)