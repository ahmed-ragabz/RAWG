package com.ragabz.rawg.data.datasource.local.entities


import com.squareup.moshi.Json

data class ParentPlatformEntity(
    @Json(name = "platform")
    val platform: PlatformEntity,
    @Json(name = "released_at")
    val releasedAt: String,
    @Json(name = "requirements")
    val requirements: RequirementsEntity
)