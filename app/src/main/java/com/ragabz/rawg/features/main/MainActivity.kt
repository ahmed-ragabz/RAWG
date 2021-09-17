package com.ragabz.rawg.features.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.ragabz.core.base.BaseVBActivity
import com.ragabz.core.extensions.createSnackBar
import com.ragabz.core.extensions.observe
import com.ragabz.core.utils.NetworkUtils
import com.ragabz.rawg.R
import com.ragabz.rawg.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseVBActivity<ActivityMainBinding, MainViewModel>(
    ActivityMainBinding::inflate
) {

    override val viewModel: MainViewModel by viewModels()
    val networkViewModel: NetworkViewModel by viewModels()

    lateinit var snackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        snackbar =
            binding.root.createSnackBar("no internet connection!", Snackbar.LENGTH_INDEFINITE)
        val navView: BottomNavigationView = binding.navView
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment_activity_main
        ) as NavHostFragment

        val navController = navHostFragment.findNavController()
        navView.setupWithNavController(navController)
        handleNetworkChanges()
    }

    private fun handleNetworkChanges() {
        observe(NetworkUtils.getNetworkLiveData(applicationContext)) { isConnected ->
            when (isConnected) {
                true -> {
                    snackbar.dismiss()
                    networkViewModel.changeToConnected()
                }
                false -> {
                    snackbar.show()
                    networkViewModel.changeToNotConnected()
                }
            }
        }
    }


}