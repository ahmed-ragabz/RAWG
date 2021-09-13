package com.ragabz.rawg.domain.repositories

import com.ragabz.core.deliverable.Result
import com.ragabz.rawg.domain.base.Repository
import com.ragabz.rawg.models.Game
import com.ragabz.rawg.models.RawgResult
import kotlinx.coroutines.flow.Flow

typealias GameListResponse = RawgResult<List<Game>>

interface GamesRepository : Repository {

    suspend fun getGamesList(
        page: Int? = null,
        pageSize: Int? = null,
        search: String? = null,
        parentPlatform: String? = null,
        platforms: String? = null,
        stores: String? = null,
        developers: String? = null,
        publishers: String? = null,
        genres: String? = null,
        tags: String? = null,
        creators: String? = null,
        dates: String? = null,
        platformsCount: Int? = null,
        excludeCollection: Int? = null,
        excludeAdditions: Boolean? = null,
        excludeParents: Boolean? = null,
        excludeGameSeries: Boolean? = null,
        ordering: String? = null
    ): Flow<Result<GameListResponse>>

    suspend fun getGameDetails(id: String): Flow<Result<Game>>


}