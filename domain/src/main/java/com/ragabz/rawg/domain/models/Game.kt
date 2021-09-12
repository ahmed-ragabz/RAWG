package com.ragabz.rawg.domain.models


data class Game(
    val added: Int,
    val addedByStatus: AddedByStatus,
    val backgroundImage: String,
    val esrbRating: EsrbRating,
    val id: Int,
    val metacritic: Int,
    val name: String,
    val platforms: List<ParentPlatform>,
    val playtime: Int,
    val rating: Int,
    val ratingTop: Int,
    val ratings: Ratings,
    val ratingsCount: Int,
    val released: String,
    val reviewsTextCount: String,
    val slug: String,
    val suggestionsCount: Int,
    val tba: Boolean,
    val updated: String
)