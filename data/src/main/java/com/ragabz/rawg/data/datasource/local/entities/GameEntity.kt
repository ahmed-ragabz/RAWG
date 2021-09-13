package com.ragabz.rawg.data.datasource.local.entities


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GameEntity(
    val added: Int,
//    val addedByStatus: AddedByStatusEntity,
    val backgroundImage: String,
//    val esrbRating: EsrbRatingEntity,
    @PrimaryKey
    val id: Int,
    val metacritic: Int,
    val name: String,
//    val platforms: List<ParentPlatformEntity>,
    val playtime: Int,
    val rating: Int,
    val ratingTop: Int,
//    val ratings: RatingsEntity,
    val ratingsCount: Int,
    val released: String,
    val reviewsTextCount: String,
    val slug: String,
    val suggestionsCount: Int,
    val tba: Boolean,
    val updated: String
)