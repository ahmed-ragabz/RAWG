package com.ragabz.rawg.features.main.gamedetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.ragabz.core.base.BaseVBFragment
import com.ragabz.core.extensions.loadImage
import com.ragabz.rawg.databinding.FragmentGameDetailsBinding
import com.ragabz.rawg.models.Game
import com.ragabz.rawg.models.ScreenShot
import dagger.hilt.android.AndroidEntryPoint
import hide
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GameDetailsFragment : BaseVBFragment<FragmentGameDetailsBinding, GameDetailsViewModel>(
    FragmentGameDetailsBinding::inflate
) {

    override val viewModel: GameDetailsViewModel by viewModels()
    override fun onInitBinding() {
        subscribeToGameDetailsViewState()
        initBottomSheetBehavior()
    }

    private fun initBottomSheetBehavior() {
        val bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetGameDetails.root)
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, viewState: Int) {
                when (viewState) {
                    BottomSheetBehavior.STATE_HIDDEN -> findNavController().popBackStack()
                    else -> Unit
                }
            }

            override fun onSlide(view: View, v: Float) {
                // do something when slide happens
            }
        })
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = GameDetailsFragmentArgs.fromBundle(requireArguments())
        viewModel.gameId = args.gameId
        viewModel.getGameDetails()
        viewModel.getScreenshots()
    }

    private fun subscribeToGameDetailsViewState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewState.collect {
                    when (it) {
                        is GameDetails -> renderGameDetails(it.game)
                        is GamesScreenshots -> renderScreenshots(it.list)
                    }
                }
            }
        }
    }

    private fun renderGameDetails(game: Game) {
        binding.apply {
            lifecycleScope.launch {
                delay(300)
                binding.bottomSheetGameDetails.progressBar.hide()
            }

            imageViewBackground.loadImage(game.backgroundImage)
            bottomSheetGameDetails.textViewGameTitle.text = game.name
            bottomSheetGameDetails.textViewReleaseDate.text = game.released
            bottomSheetGameDetails.textViewRating.text = game.rating.toString()
            bottomSheetGameDetails.textViewRatingCount.text = game.ratingsCount.toString()
            bottomSheetGameDetails.textViewPlaytime.text = game.playtime.toString()
            bottomSheetGameDetails.textViewReviewCount.text = game.reviewsTextCount.toString()
            bottomSheetGameDetails.textViewSuggestionCount.text = game.suggestionsCount.toString()
            bottomSheetGameDetails.textViewDescription.text = game.descriptionRaw
            bottomSheetGameDetails.textViewRedditDescriptionValue.text = game.redditDescription
            bottomSheetGameDetails.textViewRedditName.text = game.redditName
            bottomSheetGameDetails.textViewTbaValue.text = game.tba.toString()
        }
    }

    private fun renderScreenshots(list: List<ScreenShot>) {
        binding.apply {
            val adapter = ScreenshotsAdapter()
            bottomSheetGameDetails.recyclerViewScreenShots.adapter = adapter
            adapter.submitList(list)
        }
    }

    fun handleLoading() {
        // show or hide progress bar

    }

    fun handleError() {
        // show error layout

    }
}