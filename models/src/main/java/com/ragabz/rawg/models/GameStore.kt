package com.ragabz.rawg.models


import com.squareup.moshi.Json

data class GameStore(
    @Json(name = "game_id")
    val gameId: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "store_id")
    val storeId: String,
    @Json(name = "url")
    val url: String
)