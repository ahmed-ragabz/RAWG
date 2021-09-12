package com.ragabz.rawg.domain.models

data class Store(
    val description: String,
    val domain: String,
    val gamesCount: Int,
    val id: Int,
    val imageBackground: String,
    val name: String,
    val slug: String
)