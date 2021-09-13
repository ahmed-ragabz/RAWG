package com.ragabz.rawg.data.datasource.local.entities


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EsrbRatingEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val slug: String
)