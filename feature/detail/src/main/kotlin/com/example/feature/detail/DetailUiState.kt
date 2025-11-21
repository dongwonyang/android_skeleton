package com.example.feature.detail

sealed class DetailUiState {
    data object Success: DetailUiState()
    data object Fail: DetailUiState()
}