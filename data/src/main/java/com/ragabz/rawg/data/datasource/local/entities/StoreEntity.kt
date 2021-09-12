package com.ragabz.rawg.data.datasource.local.entities


import com.squareup.moshi.Json

data class StoreEntity(
    @Json(name = "description")
    val description: String,
    @Json(name = "domain")
    val domain: String,
    @Json(name = "games_count")
    val gamesCount: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image_background")
    val imageBackground: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "slug")
    val slug: String
)