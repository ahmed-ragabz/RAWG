package com.ragabz.core.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding


private typealias ActivityViewBindingInflater<VB> = (inflater: LayoutInflater) -> VB

abstract class BaseVBActivity<VB : ViewBinding, VM : ViewModel>(
    private val viewBindingInflater: ActivityViewBindingInflater<VB>
) : AppCompatActivity() {

    protected abstract val viewModel: VM

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = viewBindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
    }
}
