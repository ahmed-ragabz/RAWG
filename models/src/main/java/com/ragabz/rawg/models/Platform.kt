package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Platform(
    @field:Json(name = "games_count")
    val gamesCount: Int?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "image")
    val image: String?,
    @field:Json(name = "image_background")
    val imageBackground: String?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "slug")
    val slug: String?,
    @field:Json(name = "year_end")
    val yearEnd: Int?,
    @field:Json(name = "year_start")
    val yearStart: Int?
)