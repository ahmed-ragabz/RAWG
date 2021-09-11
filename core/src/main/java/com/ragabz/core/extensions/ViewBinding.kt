package com.ragabz.core.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

inline fun <reified T : ViewDataBinding> ViewGroup.inflate(
    @LayoutRes layout: Int,
    attachToRoot: Boolean = false
): T = DataBindingUtil.inflate<T>(
    LayoutInflater.from(context),
    layout,
    this,
    attachToRoot
)

inline fun <T : ViewDataBinding> T.executeAfter(block: T.() -> Unit) {
    block()
    executePendingBindings()
}