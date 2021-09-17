package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Trailer(
    @field:Json(name = "data")
    val trailerData: TrailerData,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "preview")
    val preview: String
)