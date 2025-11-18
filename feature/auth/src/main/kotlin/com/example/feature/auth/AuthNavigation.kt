package com.example.feature.auth

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.core.navigation.Route


fun NavController.navigateAuth(
    navOptions: NavOptions
) {
    navigate(Route.AuthRoute, navOptions)
}

fun NavGraphBuilder.authNavGraph(
    padding: PaddingValues,
    navigateHome: () -> Unit
) {
    composable< Route.AuthRoute> {
        AuthRoute(
            padding = padding,
            navigateHome = navigateHome,
        )
    }
}