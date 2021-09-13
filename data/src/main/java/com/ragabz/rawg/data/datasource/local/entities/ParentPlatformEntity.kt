package com.ragabz.rawg.data.datasource.local.entities

import androidx.room.Entity


@Entity
data class ParentPlatformEntity(
    val platform: PlatformEntity,
    val releasedAt: String,
    val requirements: RequirementsEntity
)