package com.ragabz.rawg.domain.repositories

import com.ragabz.rawg.domain.base.IRepository
import com.ragabz.rawg.models.Creator
import kotlinx.coroutines.flow.Flow

interface CreatorIRepository : IRepository {
    suspend fun getCreatorsList(): Flow<List<Creator>>
    suspend fun getCreatorDetails(): Flow<Creator>
}