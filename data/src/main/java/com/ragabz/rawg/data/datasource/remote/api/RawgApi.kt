package com.ragabz.rawg.data.datasource.remote.api

import com.ragabz.rawg.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

typealias RawgResponse<T> = Response<RawgResult<T>>


interface RawgApi {

    /* creators jobs */
    @GET(API_CREATORS)
    suspend fun getCreatorList(
        @Query(PAGE) page: Int,
        @Query(PAGE_SIZE) pageSize: Int
    ): RawgResponse<List<Creator>>


    @GET(API_CREATOR_DETAILS)
    suspend fun getCreatorDetails(
        @Path(ID) id: Int
    ): Response<Creator>


    /* creators */

    @GET(API_CREATOR_ROLES)
    suspend fun getCreatorPositionList(
        @Query(PAGE) page: Int,
        @Query(PAGE_SIZE) pageSize: Int
    ): RawgResponse<List<CreatorJob>>

    /* games */


    /* game developers */

    @GET(API_DEVELOPERS)
    suspend fun getDevelopers(
        @Query(PAGE) page: Int,
        @Query(PAGE_SIZE) pageSize: Int
    ): RawgResponse<List<Developer>>


    @GET(API_DEVELOPERS_DETAILS)
    suspend fun getDeveloperDetails(
        @Path(ID) id: Int
    ): Response<Developer>

    /* genres */

    @GET(API_GENRES)
    suspend fun getGenres(
        @Query(PAGE) page: Int,
        @Query(PAGE_SIZE) pageSize: Int,
        @Query(ORDERING) ordering: String = ""
    ): RawgResponse<List<Genre>>


    @GET(API_GENRE_DETAILS)
    suspend fun getGenreDetails(
        @Path(ID) id: Int
    ): Response<Genre>


    /* platforms */
    @GET(API_PLATFORMS)
    suspend fun getPlatforms(
        @Query(PAGE) page: Int,
        @Query(PAGE_SIZE) pageSize: Int,
        @Query(ORDERING) ordering: String = ""
    ): RawgResponse<List<Platform>>

    @GET(API_PLATFORMS_PARENT)
    suspend fun getParentPlatforms(
        @Query(PAGE) page: Int,
        @Query(PAGE_SIZE) pageSize: Int,
        @Query(ORDERING) ordering: String = ""
    ): RawgResponse<List<Platform>>


    @GET(API_PLATFORM_DETAILS)
    suspend fun getPlatformDetails(
        @Path(ID) id: Int
    ): Response<Platform>

    /* publishers */
    @GET(API_PUBLISHERS)
    suspend fun getPublishers(
        @Query(PAGE) page: Int,
        @Query(PAGE_SIZE) pageSize: Int,
    ): RawgResponse<List<Publisher>>


    @GET(API_PUBLISHER_DETAILS)
    suspend fun getPublisherDetails(
        @Path(ID) id: Int
    ): Response<Publisher>

    /* stores */

    @GET(API_STORES)
    suspend fun getStores(
        @Query(PAGE) page: Int,
        @Query(PAGE_SIZE) pageSize: Int,
        @Query(ORDERING) ordering: String = ""
    ): RawgResponse<List<Store>>

    @GET(API_STORES_DETAILS)
    suspend fun getStoreDetails(
        @Path(ID) id: Int
    ): Response<Store>

    /* tags */

    @GET(API_STORES)
    suspend fun getTags(
        @Query(PAGE) page: Int,
        @Query(PAGE_SIZE) pageSize: Int,
        @Query(ORDERING) ordering: String = ""
    ): RawgResponse<List<Tag>>

    @GET(API_STORES_DETAILS)
    suspend fun getTagDetails(
        @Path(ID) id: Int
    ): Response<Tag>

    /*games*/
    @GET(API_GAMES)
    suspend fun getListOfGames(
        @Query(PAGE) page: Int? = null,
        @Query(PAGE_SIZE) pageSize: Int? = null,
        @Query(SEARCH) search: String? = null,
        @Query(PARENT_PLATFORMS) parentPlatform: String? = null,
        @Query(PLATFORMS) platforms: String? = null,
        @Query(STORES) stores: String? = null,
        @Query(DEVELOPERS) developers: String? = null,
        @Query(PUBLISHERS) publishers: String? = null,
        @Query(GENRES) genres: String? = null,
        @Query(TAGS) tags: String? = null,
        @Query(CREATORS) creators: String? = null,
        @Query(DATES) dates: String? = null,
        @Query(PLATFORMS_COUNT) platformsCount: Int? = null,
        @Query(EXCLUDE_COLLECTION) excludeCollection: Int? = null,
        @Query(EXCLUDE_ADDITIONS) excludeAdditions: Boolean? = null,
        @Query(EXCLUDE_PARENTS) excludeParents: Boolean? = null,
        @Query(EXCLUDE_GAME_SERIES) excludeGameSeries: Boolean? = null,
        @Query(ORDERING) ordering: String? = null
    ): RawgResponse<List<Game>>

    /**
     * Get a list of DLC's for the game, GOTY and other editions, companion apps, etc.
     */
    @GET("games/{game_pk}/additions")
    suspend fun getDLC(
        @Path("game_pk") gamePK: String,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): RawgResponse<List<Game>>

    /**
     * Get a list of individual creators that were part of the development team.
     *
     * @property ordering string Which field to use when ordering the results.
     */
    @GET("games/{game_pk}/development-team")
    suspend fun getListOfIndividualCreators(
        @Path("game_pk") gamePK: String,
        @Query("ordering") ordering: String? = null,
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): RawgResponse<List<Creator>>


    /**
     * Get a list of games that are part of the same series.
     */
    @GET("games/{game_pk}/game-series")
    suspend fun getListOfGamesIsPartOfSameSeries(
        @Path("game_pk") gamePK: String,
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): RawgResponse<List<Game>>


    /**
     * Get a list of parent games for DLC's and editions.
     */
    @GET("games/{game_pk}/parent-games")
    suspend fun getListOfParentGamesDLC(
        @Path("game_pk") gamePK: String,
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): RawgResponse<List<Game>>


    /**
     * Get screenshots for the game.
     */
    @GET("games/{game_pk}/screenshots")
    suspend fun getScreenshotsOfTheGame(
        @Path("game_pk") gamePK: String,
        @Query("ordering") ordering: String? = null,
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): RawgResponse<List<ScreenShot>>

    /**
     * Get links to the stores that sell the game.
     */
    @GET("games/{game_pk}/stores")
    suspend fun getLinksToStoresThatSellTheGame(
        @Path("game_pk") gamePK: String,
        @Query("ordering") ordering: String? = null,
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): RawgResponse<List<GameStore>>

    /**
     * Get details of the game.
     * @return @[GameSingle]
     */
    @GET("games/{id}")
    suspend fun getGameDetails(
        @Path("id") id: String
    ): Response<Game>

    /**
     * Get a list of game achievements.
     */
    @GET("games/{id}/achievements")
    suspend fun getListOfGameAchievements(
        @Path("id") id: String
    ): RawgResponse<List<Achievement>>

    /**
     * Get a list of game trailers.
     * @property id string An ID or a slug identifying this Game.
     */
    @GET("games/{id}/movies")
    suspend fun getGameTrailers(
        @Path("id") id: String
    ): RawgResponse<List<Trailer>>

    /**
     * Get a list of most recent posts from the game's subreddit.
     */
    @GET("games/{id}/reddit")
    suspend fun getListOfMostRecentPostFromGamesSubreddit(
        @Path("id") id: String
    ): RawgResponse<List<RedditPost>>

//    /**
//     * Get a list of visually similar games.
//     */
//    @GET("games/{id}/suggested")
//    suspend fun getListOfVisualSimilarGames(
//        @Path("id") id: String
//    ): RawgApiResult<RawgData<List<GameSingle>>>
//
//    /**
//     * Get streams on Twitch associated with the game .
//     */
//    @GET("games/{id}/twitch")
//    suspend fun getTwitchStreams(
//        @Path("id") id: String
//    ): RawgApiResult<RawgData<List<TwitchStreams>>>

    /**
     * Get videos from YouTube associated with the game.
     */
    @GET("games/{id}/youtube")
    suspend fun getYoutubeChannel(
        @Path("id") id: String
    ): RawgResponse<List<YoutubeVideo>>


}