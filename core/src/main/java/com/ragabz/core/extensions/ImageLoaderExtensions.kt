package com.ragabz.core.extensions

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.ragabz.core.R

fun ImageView.loadImage(
    url: String?,
    placeholder: CircularProgressDrawable = defaultCircularProgressDrawable()
) =
    Glide.with(this)
        .load(url ?: "")
        .placeholder(placeholder)
        .error(R.color.placeholder)
        .into(this)

fun ImageView.loadImageRound(url: String, placeholder: CircularProgressDrawable) =
    Glide.with(this).load(url)
        .placeholder(placeholder)
        .error(R.color.placeholder)
        .circleCrop()
        .into(this)


fun ImageView.defaultCircularProgressDrawable(): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }
}