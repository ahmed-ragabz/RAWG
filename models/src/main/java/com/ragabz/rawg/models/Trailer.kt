package com.ragabz.rawg.models


import com.squareup.moshi.Json

data class Trailer(
    @Json(name = "data")
    val trailerData: TrailerData,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "preview")
    val preview: String
)