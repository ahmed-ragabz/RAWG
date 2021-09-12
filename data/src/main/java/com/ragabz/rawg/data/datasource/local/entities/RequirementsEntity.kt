package com.ragabz.rawg.data.datasource.local.entities


import com.squareup.moshi.Json

data class RequirementsEntity(
    @Json(name = "minimum")
    val minimum: String,
    @Json(name = "recommended")
    val recommended: String
)