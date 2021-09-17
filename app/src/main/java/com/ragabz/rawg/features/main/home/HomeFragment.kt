package com.ragabz.rawg.features.main.home

import androidx.fragment.app.viewModels
import com.ragabz.core.base.BaseVBFragment
import com.ragabz.rawg.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
    BaseVBFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {

    override val viewModel: HomeViewModel by viewModels()


    override fun onInitBinding() {
        requireActivity().actionBar?.hide()
    }
}