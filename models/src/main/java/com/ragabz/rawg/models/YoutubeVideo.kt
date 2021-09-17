package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class YoutubeVideo(
    @field:Json(name = "channel_id")
    val channelId: String,
    @field:Json(name = "channel_title")
    val channelTitle: String,
    @field:Json(name = "comments_count")
    val commentsCount: Int,
    @field:Json(name = "created")
    val created: String,
    @field:Json(name = "description")
    val description: String,
    @field:Json(name = "dislike_count")
    val dislikeCount: Int,
    @field:Json(name = "external_id")
    val externalId: String,
    @field:Json(name = "favorite_count")
    val favoriteCount: Int,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "like_count")
    val likeCount: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "thumbnails")
    val thumbnails: Thumbnails?,
    @field:Json(name = "view_count")
    val viewCount: Int
)