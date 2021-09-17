package com.ragabz.rawg.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ParentPlatform(
    @field:Json(name = "platform")
    val platform: Platform?,
    @field:Json(name = "released_at")
    val releasedAt: String?,
    @field:Json(name = "requirements_en")
    val requirementsEN: Requirements?,
    @field:Json(name = "requirements_ru")
    val requirementsRU: Requirements?
)