package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Achievement(
    @field:Json(name = "description")
    val description: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "image")
    val image: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "percent")
    val percent: String
)