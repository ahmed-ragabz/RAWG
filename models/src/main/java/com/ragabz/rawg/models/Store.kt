package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Store(
    @field:Json(name = "description")
    val description: String,
    @field:Json(name = "domain")
    val domain: String,
    @field:Json(name = "games_count")
    val gamesCount: Int,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "image_background")
    val imageBackground: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "slug")
    val slug: String
)