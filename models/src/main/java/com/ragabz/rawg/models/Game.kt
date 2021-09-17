package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Game(
    @field:Json(name = "added")
    val added: Int,
    @field:Json(name = "added_by_status")
    val addedByStatus: AddedByStatus?,
    @field:Json(name = "background_image")
    val backgroundImage: String?,
    @field:Json(name = "esrb_rating")
    val esrbRating: EsrbRating?,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "metacritic")
    val metacritic: Int?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "platforms")
    val platforms: List<Platform>?,
    @field:Json(name = "playtime")
    val playtime: Int?,
    @field:Json(name = "rating")
    val rating: Float?,
    @field:Json(name = "rating_top")
    val ratingTop: Int?,
    @field:Json(name = "ratings")
    val ratings: List<Ratings>?,
    @field:Json(name = "ratings_count")
    val ratingsCount: Int?,
    @field:Json(name = "released")
    val released: String?,
    @field:Json(name = "reviews_text_count")
    val reviewsTextCount: String?,
    @field:Json(name = "slug")
    val slug: String?,
    @field:Json(name = "suggestions_count")
    val suggestionsCount: Int?,
    @field:Json(name = "tba")
    val tba: Boolean,
    @field:Json(name = "updated")
    val updated: String?,
    @field:Json(name = "description_raw")
    val descriptionRaw: String?,
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "reddit_description")
    val redditDescription: String?,
    @field:Json(name = "reddit_name")
    val redditName: String?,
    @field:Json(name = "tags")
    val tags: List<Tag>?
)