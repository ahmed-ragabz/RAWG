package com.ragabz.rawg.data.repositories

import com.ragabz.core.deliverable.Result
import com.ragabz.rawg.data.datasource.remote.api.RawgApi
import com.ragabz.rawg.data.extensions.toFlow
import com.ragabz.rawg.domain.repositories.GameListResponse
import com.ragabz.rawg.domain.repositories.GamesRepository
import com.ragabz.rawg.models.Game
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val rawgApi: RawgApi
): GamesRepository {

    override suspend fun getGamesList(
        page: Int?,
        pageSize: Int?,
        search: String?,
        parentPlatform: String?,
        platforms: String?,
        stores: String?,
        developers: String?,
        publishers: String?,
        genres: String?,
        tags: String?,
        creators: String?,
        dates: String?,
        platformsCount: Int?,
        excludeCollection: Int?,
        excludeAdditions: Boolean?,
        excludeParents: Boolean?,
        excludeGameSeries: Boolean?,
        ordering: String?
    ): Flow<Result<GameListResponse>> {
        return rawgApi.getListOfGames().toFlow()
    }

    override suspend fun getGameDetails(id: String): Flow<Result<Game>> {
        return rawgApi.getGameDetails(id).toFlow()
    }
}