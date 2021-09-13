package com.ragabz.rawg.models


import com.squareup.moshi.Json

data class Game(
    @Json(name = "added")
    val added: Int,
    @Json(name = "added_by_status")
    val addedByStatus: AddedByStatus,
    @Json(name = "background_image")
    val backgroundImage: String,
    @Json(name = "esrb_rating")
    val esrbRating: EsrbRating,
    @Json(name = "id")
    val id: Int,
    @Json(name = "metacritic")
    val metacritic: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "platforms")
    val platforms: List<ParentPlatform>,
    @Json(name = "playtime")
    val playtime: Int,
    @Json(name = "rating")
    val rating: Int,
    @Json(name = "rating_top")
    val ratingTop: Int,
    @Json(name = "ratings")
    val ratings: Ratings,
    @Json(name = "ratings_count")
    val ratingsCount: Int,
    @Json(name = "released")
    val released: String,
    @Json(name = "reviews_text_count")
    val reviewsTextCount: String,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "suggestions_count")
    val suggestionsCount: Int,
    @Json(name = "tba")
    val tba: Boolean,
    @Json(name = "updated")
    val updated: String
)