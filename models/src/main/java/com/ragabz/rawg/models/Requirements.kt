package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Requirements(
    @field:Json(name = "minimum")
    val minimum: String,
    @field:Json(name = "recommended")
    val recommended: String
)