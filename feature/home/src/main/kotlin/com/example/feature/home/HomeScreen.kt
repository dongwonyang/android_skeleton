package com.example.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.designsystem.theme.Dimens
import com.example.feature.home.component.SampleListItem
import com.example.feature.home.component.SampleListScreen

@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    navigateMy: () -> Unit
) {
//    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        padding = padding
    )
}

@Composable
private fun HomeScreen(
    padding: PaddingValues
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(padding)
            .padding(Dimens.common)
            .fillMaxSize(),
    ) {
        SampleListScreen(
            items = listOf("sample1", "sample2"),
            onItemClick = {},
        )
    }
}
