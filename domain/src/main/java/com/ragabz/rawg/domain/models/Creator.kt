package com.ragabz.rawg.domain.models

data class Creator(
    val description: String,
    val gamesCount: Int,
    val id: Int,
    val image: String,
    val imageBackground: String,
    val name: String,
    val rating: String,
    val ratingTop: Int,
    val reviewsCount: Int,
    val slug: String,
    val updated: String
)