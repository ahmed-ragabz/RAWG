package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RedditPost(
    @field:Json(name = "created")
    val created: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "image")
    val image: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "text")
    val text: String,
    @field:Json(name = "url")
    val url: String,
    @field:Json(name = "username")
    val username: String,
    @field:Json(name = "username_url")
    val usernameUrl: String
)