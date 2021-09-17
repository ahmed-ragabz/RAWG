package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Creator(
    @field:Json(name = "description")
    val description: String,
    @field:Json(name = "games_count")
    val gamesCount: Int,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "image")
    val image: String,
    @field:Json(name = "image_background")
    val imageBackground: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "rating")
    val rating: List<Ratings>,
    @field:Json(name = "rating_top")
    val ratingTop: Int,
    @field:Json(name = "reviews_count")
    val reviewsCount: Int,
    @field:Json(name = "slug")
    val slug: String?,
    @field:Json(name = "updated")
    val updated: String?
)