package com.ragabz.rawg.features.main.browse

import androidx.fragment.app.viewModels
import com.ragabz.core.base.BaseVBFragment
import com.ragabz.rawg.databinding.FragmentBrowseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BrowseFragment : BaseVBFragment<FragmentBrowseBinding, BrowseViewModel>(
    FragmentBrowseBinding::inflate
) {
    override val viewModel: BrowseViewModel by viewModels()

    override fun onInitBinding() {

    }
}