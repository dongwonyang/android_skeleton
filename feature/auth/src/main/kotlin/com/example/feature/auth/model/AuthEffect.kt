package com.example.feature.auth.model

sealed interface AuthEvent {
    data class EmailChanged(val value: String) : AuthEvent
    data class PasswordChanged(val value: String) : AuthEvent
    data object LoginClicked : AuthEvent
    data object SignupClicked : AuthEvent
}

sealed interface AuthEffect {
    data object NavigateHome : AuthEffect
    data class ShowSnackBar(val message: String) : AuthEffect
}
