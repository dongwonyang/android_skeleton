package com.example.core.navigation

import androidx.annotation.IdRes

sealed class Route(val route: String) {
    object Auth : Route("auth")
    object Home : Route("home")
    object Profile : Route("profile")
    object Detail : Route("detail")
}
