package com.ragabz.rawg.models


import com.squareup.moshi.Json

data class RedditPost(
    @Json(name = "created")
    val created: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "text")
    val text: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "username")
    val username: String,
    @Json(name = "username_url")
    val usernameUrl: String
)