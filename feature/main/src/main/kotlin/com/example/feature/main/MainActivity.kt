package com.example.feature.main

import android.os.Bundle
import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.core.navigation.LoginNavigator
import com.example.core.navigation.Route
import com.example.core.navigation.resetStackNavOptions
import com.example.feature.main.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), LoginNavigator {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        initViewModel()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.navHostFragment.id) as NavHostFragment
        navController = navHostFragment.navController

        fun bindingBotNav() {
            val bottomNavView = binding.bottomNavigationView

            NavigationUI.setupWithNavController(bottomNavView, navController)

            navController.addOnDestinationChangedListener { _, destination, _ ->
                bottomNavView.isVisible = destination.id in setOf(
                    R.id.homeFragment,
                    R.id.detailFragment,
                    R.id.profileFragment
                )
            }
        }


        fun setFinish() {
            onBackPressedDispatcher.addCallback(this) {
                val currentDestination = navController.currentDestination?.id
                val startDestination = navController.graph.startDestinationId

                if (currentDestination == startDestination) {
                    finish()
                } else {
                    navController.popBackStack()
                }
            }
        }

        setNavGraph(false)
        bindingBotNav()
        setFinish()
    }


    fun setNavGraph(isAlreadyLogin: Boolean) {
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        if (isAlreadyLogin) {
            navGraph.setStartDestination(R.id.homeFragment)
        } else {
            navGraph.setStartDestination(R.id.authFragment)
        }
        navController.setGraph(navGraph, null)
    }

    fun initViewModel() = with(viewModel) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                uiState.collectLatest { uiState ->

                }
            }
        }
    }

    override fun setStartDestinationHome() {
        setNavGraph(true)
        navController.navigate(Route.Home.route, resetStackNavOptions)
    }

}
