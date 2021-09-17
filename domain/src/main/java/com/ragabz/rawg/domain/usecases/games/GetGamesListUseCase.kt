package com.ragabz.rawg.domain.usecases.games

import com.ragabz.core.deliverable.Result
import com.ragabz.rawg.domain.base.FlowUseCase
import com.ragabz.rawg.domain.di.IODispatcher
import com.ragabz.rawg.domain.repositories.GameListResponse
import com.ragabz.rawg.domain.repositories.GamesRepository
import com.ragabz.rawg.domain.requests.GamesSearchRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGamesListUseCase @Inject constructor(

    private val gamesRepository: GamesRepository,
    @IODispatcher private val dispatcher : CoroutineDispatcher

): FlowUseCase<GamesSearchRequest, GameListResponse>(dispatcher)  {
    override suspend fun execute(parameters: GamesSearchRequest): Flow<Result<GameListResponse>> {
        return gamesRepository.getGamesList(
            page = parameters.page,
            pageSize = parameters.pageSize,
            search = null,
            parentPlatform = null,
            platforms = null,
            stores = null,
            developers = null,
            publishers = null,
            genres = null,
            tags = null,
            creators = null,
            dates = null,
            platformsCount = null,
            excludeCollection = null,
            excludeAdditions = null,
            excludeParents = null,
            excludeGameSeries = null,
            ordering = null
        )
    }
}