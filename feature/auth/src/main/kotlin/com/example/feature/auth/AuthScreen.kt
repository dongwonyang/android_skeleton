package com.example.feature.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.designsystem.theme.Dimens
import com.example.feature.auth.component.LoginContent
import com.example.feature.auth.model.AuthEffect
import com.example.feature.auth.model.AuthEvent
import com.example.feature.auth.model.AuthUiState

@Composable
internal fun AuthRoute(
    padding: PaddingValues,
    navigateHome: () -> Unit,
    viewModel: AuthViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { eff ->
            when (eff) {
                AuthEffect.NavigateHome -> navigateHome()
                else -> {}
            }
        }
    }

    AuthScreen(
        padding = padding,
        uiState = uiState,
        onEvent = viewModel::onEvent
    )
}


@Composable
private fun AuthScreen(
    padding: PaddingValues,
    uiState: AuthUiState,
    onEvent: (AuthEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(padding)
            .padding(Dimens.common)
            .fillMaxSize(),
    ) {
        LoginContent(
            email = uiState.email,
            password = uiState.password,
            onEmailChange = { onEvent(AuthEvent.EmailChanged(it)) },
            onPasswordChange = { onEvent(AuthEvent.PasswordChanged(it)) },
            onLoginClick = { onEvent(AuthEvent.LoginClicked) },
            onSignupClick = { onEvent(AuthEvent.SignupClicked) },
        )
    }
}
