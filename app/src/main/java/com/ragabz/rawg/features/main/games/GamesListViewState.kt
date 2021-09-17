package com.ragabz.rawg.features.main.games

import com.ragabz.rawg.models.Game

data class GamesListViewState(
    val isLoading: Boolean,
    val list: List<Game>
) {
    companion object {
        fun empty(): GamesListViewState {
            return GamesListViewState(false, emptyList())
        }
    }
}