package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScreenShot(
    @field:Json(name = "hidden")
    val hidden: Boolean= false,
    @field:Json(name = "image")
    val image: String?
)