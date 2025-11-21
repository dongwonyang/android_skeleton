package com.example.feature.home

sealed class HomeUiState {
    data class Success(val list: List<String> = listOf("sample1", "sample2", "sample3")): HomeUiState()
    data object Fail: HomeUiState()
}