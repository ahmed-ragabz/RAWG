package com.ragabz.rawg.domain.models

data class ParentPlatform(
    val platform: Platform,
    val releasedAt: String,
    val requirements: Requirements
)