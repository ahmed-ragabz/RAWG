package com.ragabz.rawg.data.datasource.remote

import com.squareup.moshi.Json

data class RAWGBaseResponse<T>(
    @Json(name = "count") val count: Int,
    @Json(name = "next") val next: String,
    @Json(name = "previous") val previous: String,
    @Json(name = "results") val results: T
)