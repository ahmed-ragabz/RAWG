package com.ragabz.rawg.domain.usecases.games

import com.ragabz.core.deliverable.Result
import com.ragabz.rawg.domain.base.FlowUseCase
import com.ragabz.rawg.domain.di.IODispatcher
import com.ragabz.rawg.domain.repositories.GamesRepository
import com.ragabz.rawg.domain.repositories.VideosListResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetYoutubeVideosUseCase @Inject constructor(
    private val gamesRepository: GamesRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : FlowUseCase<Int, VideosListResponse>(dispatcher) {
    override suspend fun execute(parameters: Int): Flow<Result<VideosListResponse>> {
        return gamesRepository.getGameVideos(parameters)
    }
}