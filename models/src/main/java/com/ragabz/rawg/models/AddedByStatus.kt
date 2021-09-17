package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AddedByStatus(
    @field:Json(name = "beaten")
    val beaten: Int?,
    @field:Json(name = "dropped")
    val dropped: Int?,
    @field:Json(name = "owned")
    val owned: Int?,
    @field:Json(name = "playing")
    val playing: Int?,
    @field:Json(name = "toplay")
    val toplay: Int?,
    @field:Json(name = "yet")
    val yet: Int?
)