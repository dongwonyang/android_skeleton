package com.example.feature.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.core.navigation.MainTabRoute

fun NavController.navigateHome(
    navOptions: NavOptions
) {
    navigate(MainTabRoute.Home, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    padding: PaddingValues,
    navigateMy: () -> Unit
) {
    composable<MainTabRoute.Home> {
        HomeRoute(
            padding = padding,
            navigateMy = navigateMy
        )
    }
}