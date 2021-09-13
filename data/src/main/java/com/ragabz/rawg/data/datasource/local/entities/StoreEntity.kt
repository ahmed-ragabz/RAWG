package com.ragabz.rawg.data.datasource.local.entities


data class StoreEntity(
    val description: String,
    val domain: String,
    val gamesCount: Int,
    val id: Int,
    val imageBackground: String,
    val name: String,
    val slug: String
)