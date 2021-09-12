package com.ragabz.rawg.data.datasource.local.entities


import com.squareup.moshi.Json

data class PlatformEntity(
    @Json(name = "games_count")
    val gamesCount: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "image_background")
    val imageBackground: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "year_end")
    val yearEnd: Int,
    @Json(name = "year_start")
    val yearStart: Int
)