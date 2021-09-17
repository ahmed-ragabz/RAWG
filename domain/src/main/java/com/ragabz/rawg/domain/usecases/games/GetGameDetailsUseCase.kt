package com.ragabz.rawg.domain.usecases.games

import com.ragabz.core.deliverable.Result
import com.ragabz.rawg.domain.base.FlowUseCase
import com.ragabz.rawg.domain.di.IODispatcher
import com.ragabz.rawg.domain.repositories.GamesRepository
import com.ragabz.rawg.models.Game
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGameDetailsUseCase @Inject constructor(
    private val gamesRepository: GamesRepository,
    @IODispatcher private val dispatechers: CoroutineDispatcher
) : FlowUseCase<Int, Game>(dispatechers) {
    override suspend fun execute(parameters: Int): Flow<Result<Game>> {
        return gamesRepository.getGameDetails("$parameters")
    }
}