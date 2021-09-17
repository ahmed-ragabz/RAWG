package com.ragabz.rawg.features.main.gamedetails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ragabz.core.base.ViewBindingHolder
import com.ragabz.core.extensions.loadImage
import com.ragabz.rawg.databinding.ItemScreenshotBinding
import com.ragabz.rawg.models.ScreenShot

class ScreenshotsAdapter() :
    ListAdapter<ScreenShot, ScreenshotsAdapter.ScreenshotsViewHolder>(ScreenshotDiffCallback()) {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenshotsViewHolder {
        context = parent.context
        return ScreenshotsViewHolder(
            ItemScreenshotBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ScreenshotsViewHolder, position: Int) {
        (holder.binding as ItemScreenshotBinding).apply {
            val item = getItem(position)
            imageView.loadImage(item.image)

        }
    }

    /* diff callback*/
    internal class ScreenshotDiffCallback : DiffUtil.ItemCallback<ScreenShot>() {
        override fun areItemsTheSame(oldItem: ScreenShot, newItem: ScreenShot): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(oldItem: ScreenShot, newItem: ScreenShot): Boolean {
            return oldItem.image == newItem.image
        }
    }

    class ScreenshotsViewHolder(itemview: ItemScreenshotBinding) : ViewBindingHolder(itemview)
}