package com.ragabz.rawg.features.main.gamedetails

import com.ragabz.rawg.models.Game
import com.ragabz.rawg.models.ScreenShot
import com.ragabz.rawg.models.YoutubeVideo
import com.ragabz.rawg.state.ViewState

sealed class GameDetailsViewState : ViewState

object Loading : GameDetailsViewState()
object Error : GameDetailsViewState()

data class GameDetails(val game: Game) : GameDetailsViewState()

data class GamesScreenshots(val list: List<ScreenShot>) : GameDetailsViewState()
data class GameVideos(val list: List<YoutubeVideo>) : GameDetailsViewState()
