package com.ragabz.core.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


/* ViewHolder used with databinding */
open class DataBindingHolder(view: View) : RecyclerView.ViewHolder(view) {
    var binding: ViewDataBinding? = null

    init {
        binding = DataBindingUtil.bind(view)
    }
}


/* ViewHolder used with ViewBinding */
open class ViewBindingHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)