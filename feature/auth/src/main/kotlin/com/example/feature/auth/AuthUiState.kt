package com.example.feature.auth

sealed class AuthUiState {
    data class Login(val email: String = "", val password: String = ""): AuthUiState()
    data object OnLogin: AuthUiState()
}