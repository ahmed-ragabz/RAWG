package com.ragabz.rawg.models

import com.squareup.moshi.Json

data class RawgResult<T>(
    @Json(name = "count") val count: Int,
    @Json(name = "next") val next: String,
    @Json(name = "previous") val previous: String,
    @Json(name = "results") val results: T
)