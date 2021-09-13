package com.ragabz.rawg.models


import com.squareup.moshi.Json

data class YoutubeVideo(
    @Json(name = "channel_id")
    val channelId: String,
    @Json(name = "channel_title")
    val channelTitle: String,
    @Json(name = "comments_count")
    val commentsCount: Int,
    @Json(name = "created")
    val created: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "dislike_count")
    val dislikeCount: Int,
    @Json(name = "external_id")
    val externalId: String,
    @Json(name = "favorite_count")
    val favoriteCount: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "like_count")
    val likeCount: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "thumbnails")
    val thumbnails: Thumbnails,
    @Json(name = "view_count")
    val viewCount: Int
)