package com.ragabz.rawg.features.main.gamedetails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ragabz.core.base.ViewBindingHolder
import com.ragabz.core.extensions.loadImage
import com.ragabz.rawg.databinding.ItemYoutubeVideoBinding
import com.ragabz.rawg.models.YoutubeVideo

class VideosAdapter() :
    ListAdapter<YoutubeVideo, VideosAdapter.VideosViewHolder>(VideosDiffCallback()) {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        context = parent.context
        return VideosViewHolder(
            ItemYoutubeVideoBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        (holder.binding as ItemYoutubeVideoBinding).apply {
            val item = getItem(position)
            imageView.loadImage("item.thumbnails")

        }
    }

    /* diff callback*/
    internal class VideosDiffCallback : DiffUtil.ItemCallback<YoutubeVideo>() {
        override fun areItemsTheSame(oldItem: YoutubeVideo, newItem: YoutubeVideo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: YoutubeVideo, newItem: YoutubeVideo): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class VideosViewHolder(itemview: ItemYoutubeVideoBinding) : ViewBindingHolder(itemview)
}