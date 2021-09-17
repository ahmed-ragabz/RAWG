package com.ragabz.core.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.ragabz.core.R

@BindingAdapter(value = ["imageUrl"], requireAll = false)
fun ImageView.loadImageFromUrl(imageUrl: String?) {
    // create request options to set placeholder or error
    val options = RequestOptions()
        .placeholder(R.drawable.image_placeholder)
        .error(R.drawable.image_placeholder)

    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(imageUrl ?: "")
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}
