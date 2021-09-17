package com.ragabz.rawg.features.main.games

import androidx.lifecycle.viewModelScope
import com.ragabz.core.base.BaseViewModel
import com.ragabz.core.deliverable.runIfSuccess
import com.ragabz.rawg.PAGE_SIZE_VALUE
import com.ragabz.rawg.domain.requests.GamesSearchRequest
import com.ragabz.rawg.domain.usecases.games.GetGamesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val getGamesListUseCase: GetGamesListUseCase
) : BaseViewModel() {

    private var currentPage = 1
    private val _gamesList = MutableStateFlow<GamesListViewState>(GamesListViewState.empty())
    val gamesList: StateFlow<GamesListViewState> = _gamesList

    init {
        getGamesList(true)
    }

    @OptIn(InternalCoroutinesApi::class)
    fun getGamesList(refresh: Boolean) {
        if (refresh) currentPage = 1
        viewModelScope.launch {
            getGamesListUseCase.invoke(
                GamesSearchRequest(page = currentPage, pageSize = PAGE_SIZE_VALUE)
            ).collect { result ->
                result.runIfSuccess {
                    it.results.let { response ->
                        val newList = if (!refresh) _gamesList.value.list + response else response
                        currentPage += 1
                        _gamesList.value = GamesListViewState(false, newList)
                    }
                }
            }
        }
    }

    fun getGameId(position: Int): Int {
        return if (_gamesList.value.list.isEmpty())
            -1 else _gamesList.value.list[position].id
    }

}