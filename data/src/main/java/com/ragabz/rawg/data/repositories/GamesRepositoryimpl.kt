package com.ragabz.rawg.data.repositories

import com.ragabz.core.deliverable.Result
import com.ragabz.rawg.data.datasource.local.daos.GamesDao
import com.ragabz.rawg.data.datasource.local.entities.GameEntity
import com.ragabz.rawg.data.datasource.remote.api.RawgApi
import com.ragabz.rawg.data.extensions.toFlow
import com.ragabz.rawg.data.extensions.whenSuccess
import com.ragabz.rawg.domain.repositories.GameListResponse
import com.ragabz.rawg.domain.repositories.GamesRepository
import com.ragabz.rawg.domain.repositories.ScreenShotsResponse
import com.ragabz.rawg.domain.repositories.VideosListResponse
import com.ragabz.rawg.models.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val gamesDao: GamesDao,
    private val rawgApi: RawgApi
) : GamesRepository {

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
        val response = rawgApi.getListOfGames(page = page, pageSize = pageSize)
        with(response) {
            whenSuccess {
                GameEntity.fromNetwork(it.results).let {
                    Timber.i(it.toString())
                    CoroutineScope(Dispatchers.IO).launch {
                        gamesDao.insertAllGames(it)
                    }
                }
            }
            return response.toFlow()
        }
    }

    override suspend fun getGameDetails(id: String): Flow<Result<Game>> {
        return rawgApi.getGameDetails(id).toFlow()
    }

    override suspend fun getGamesScreenShotList(gameId: Int): Flow<Result<ScreenShotsResponse>> {
        return rawgApi.getScreenshotsOfTheGame("$gameId").toFlow()
    }

    override suspend fun getGameVideos(gameId: Int): Flow<Result<VideosListResponse>> {
        return rawgApi.getYoutubeChannel("$gameId").toFlow()
    }
}