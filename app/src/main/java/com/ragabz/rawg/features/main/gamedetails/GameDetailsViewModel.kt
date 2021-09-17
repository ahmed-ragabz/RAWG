package com.ragabz.rawg.features.main.gamedetails

import androidx.lifecycle.viewModelScope
import com.ragabz.core.base.BaseViewModel
import com.ragabz.core.deliverable.runIfError
import com.ragabz.core.deliverable.runIfLoading
import com.ragabz.core.deliverable.runIfSuccess
import com.ragabz.rawg.domain.usecases.games.GetGameDetailsUseCase
import com.ragabz.rawg.domain.usecases.games.GetScreenshotsOfTheGame
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GameDetailsViewModel @Inject constructor(
    private val getGameDetailsUseCase: GetGameDetailsUseCase,
    private val getScreenshotsOfTheGame: GetScreenshotsOfTheGame
) : BaseViewModel() {
    var gameId: Int = 0

    private val _viewState = MutableStateFlow<GameDetailsViewState>(Loading)
    val viewState: StateFlow<GameDetailsViewState> = _viewState

    fun getGameDetails() {
        viewModelScope.launch {
            getGameDetailsUseCase.invoke(gameId).collect {
                it.runIfSuccess { game ->
                    _viewState.value = GameDetails(game)
                }
                it.runIfError { exception ->
                    Timber.e(exception)
                }
                it.runIfLoading {
                    Timber.i("show loading....")
                }
            }
        }
    }

    fun getScreenshots() {
        viewModelScope.launch {
            getScreenshotsOfTheGame.invoke(gameId).collect {
                it.runIfSuccess {
                    _viewState.value = GamesScreenshots(it.results)
                }
                it.runIfError {
                    Timber.e(it)
                }
            }
        }
    }
}