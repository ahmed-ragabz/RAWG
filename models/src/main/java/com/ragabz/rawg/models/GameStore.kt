package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameStore(
    @field:Json(name = "game_id")
    val gameId: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "store_id")
    val storeId: String,
    @field:Json(name = "url")
    val url: String
)