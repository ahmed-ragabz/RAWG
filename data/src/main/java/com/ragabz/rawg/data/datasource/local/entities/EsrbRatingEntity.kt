package com.ragabz.rawg.data.datasource.local.entities


import com.squareup.moshi.Json

data class EsrbRatingEntity(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "slug")
    val slug: String
)