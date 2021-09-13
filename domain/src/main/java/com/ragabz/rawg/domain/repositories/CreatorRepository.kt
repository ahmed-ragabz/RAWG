package com.ragabz.rawg.domain.repositories

import com.ragabz.rawg.domain.base.Repository
import com.ragabz.rawg.models.Creator
import kotlinx.coroutines.flow.Flow

interface CreatorRepository : Repository {
    suspend fun getCreatorsList(): Flow<List<Creator>>
    suspend fun getCreatorDetails(): Flow<Creator>
}