package com.ragabz.rawg.features.main.profile

import androidx.fragment.app.viewModels
import com.ragabz.core.base.BaseVBFragment
import com.ragabz.rawg.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment :
    BaseVBFragment<FragmentProfileBinding, ProfileViewModel>(FragmentProfileBinding::inflate) {

    override val viewModel: ProfileViewModel by viewModels()

    override fun onInitBinding() {

    }

}