package com.ragabz.rawg.domain.models

data class Tag(
    val description: String,
    val gamesCount: Int,
    val id: Int,
    val imageBackground: String,
    val name: String,
    val slug: String
)