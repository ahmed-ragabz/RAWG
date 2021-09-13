package com.ragabz.rawg.data.datasource.local.entities


data class PlatformEntity(
    val gamesCount: Int,
    val id: Int,
    val image: String,
    val imageBackground: String,
    val name: String,
    val slug: String,
    val yearEnd: Int,
    val yearStart: Int
)