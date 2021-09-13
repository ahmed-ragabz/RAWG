package com.ragabz.rawg.models


import com.squareup.moshi.Json

data class Requirements(
    @Json(name = "minimum")
    val minimum: String,
    @Json(name = "recommended")
    val recommended: String
)