package com.ragabz.rawg.features.main.games

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.nukc.LoadMoreWrapper.LoadMoreWrapper
import com.ragabz.core.base.BaseVBFragment
import com.ragabz.core.utils.ItemClickSupport
import com.ragabz.rawg.R
import com.ragabz.rawg.databinding.FragmentGamesBinding
import com.ragabz.rawg.features.main.NetworkViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GamesFragment : BaseVBFragment<FragmentGamesBinding, GamesViewModel>(
    FragmentGamesBinding::inflate
) {

    private lateinit var gamesAdapter: GamesAdapter
    override val viewModel: GamesViewModel by viewModels()
    val networkViewModel: NetworkViewModel by activityViewModels()

    override fun onInitBinding() {
        gamesAdapter = GamesAdapter()
        binding.recyclerView.adapter = gamesAdapter
        subscribeOnViewModelState()
        initPullToRefreshListener()
        initRecyclerViewClickListener()
        initRecyclerViewScrollListener()
    }

    private fun subscribeOnViewModelState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.gamesList.collectLatest {
                    if (binding.swipeToRefresh.isRefreshing) {
                        binding.swipeToRefresh.isRefreshing = false
                    }
                    gamesAdapter.submitList(it.list)
                }
            }
        }
    }

    private fun initPullToRefreshListener() {
        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.getGamesList(true)
        }
    }

    private fun initRecyclerViewClickListener() {
        ItemClickSupport.addTo(binding.recyclerView).setOnItemClickListener(
            object : ItemClickSupport.OnItemClickListener {
                override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                    if (networkViewModel.isConnected())
                        navigateToDetails(viewModel.getGameId(position))
                }
            }
        )
    }

    private fun initRecyclerViewScrollListener() {
        LoadMoreWrapper.with(gamesAdapter)
            .setFooterView(R.layout.load_more).setShowNoMoreEnabled(false)
            .setListener { viewModel.getGamesList(false) }.into(binding.recyclerView)
    }

    private fun navigateToDetails(gameId: Int) {
        val action = GamesFragmentDirections.actionNavigationGamesToGameDetailsFragment(gameId)
        findNavController().navigate(action)
    }
}