package com.ragabz.rawg.models


import com.squareup.moshi.Json

data class EsrbRating(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "slug")
    val slug: String
)