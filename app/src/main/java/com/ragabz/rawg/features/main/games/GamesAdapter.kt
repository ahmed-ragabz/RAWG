package com.ragabz.rawg.features.main.games

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ragabz.core.base.ViewBindingHolder
import com.ragabz.core.extensions.loadImage
import com.ragabz.rawg.databinding.ItemGameBinding
import com.ragabz.rawg.models.Game

class GamesAdapter() : ListAdapter<Game, GamesAdapter.GameViewHolder>(GamesDiffCallback()) {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        context = parent.context
        return GameViewHolder(
            ItemGameBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        (holder.binding as ItemGameBinding).apply {
            val game = getItem(position)
            imageView.loadImage(game.backgroundImage)
            textGameTitle.text = game.name
            textViewRating.text = game.rating.toString()
            textViewDate.text = game.released
        }
    }

    /* diff callback*/
    internal class GamesDiffCallback : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class GameViewHolder(itemview: ItemGameBinding) : ViewBindingHolder(itemview)
}