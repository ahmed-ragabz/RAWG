package com.ragabz.rawg.data.datasource.remote.models


import com.squareup.moshi.Json

data class Requirements(
    @Json(name = "minimum")
    val minimum: String,
    @Json(name = "recommended")
    val recommended: String
)