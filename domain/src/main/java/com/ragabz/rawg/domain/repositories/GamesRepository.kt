package com.ragabz.rawg.domain.repositories

import com.ragabz.core.deliverable.Result
import com.ragabz.rawg.domain.base.IRepository
import com.ragabz.rawg.models.Game
import com.ragabz.rawg.models.RawgResult
import com.ragabz.rawg.models.ScreenShot
import com.ragabz.rawg.models.YoutubeVideo
import kotlinx.coroutines.flow.Flow

typealias GameListResponse = RawgResult<List<Game>>
typealias ScreenShotsResponse = RawgResult<List<ScreenShot>>
typealias VideosListResponse = RawgResult<List<YoutubeVideo>>

interface GamesRepository : IRepository {

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

    suspend fun getGamesScreenShotList(gameId: Int): Flow<Result<ScreenShotsResponse>>
    suspend fun getGameVideos(gameId: Int): Flow<Result<VideosListResponse>>


}