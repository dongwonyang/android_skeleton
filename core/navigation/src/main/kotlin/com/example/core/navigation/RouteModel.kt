package com.example.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object AuthRoute: Route

}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object My : MainTabRoute
}