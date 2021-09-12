package com.ragabz.rawg.data.datasource.remote.models


import com.squareup.moshi.Json

data class Creator(
    @Json(name = "description")
    val description: String,
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
    @Json(name = "rating")
    val rating: String,
    @Json(name = "rating_top")
    val ratingTop: Int,
    @Json(name = "reviews_count")
    val reviewsCount: Int,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "updated")
    val updated: String
)