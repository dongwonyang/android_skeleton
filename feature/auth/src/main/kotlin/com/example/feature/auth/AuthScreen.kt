package com.example.feature.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.core.designsystem.theme.Dimens
import com.example.feature.auth.component.LoginContent
import com.example.feature.auth.model.AuthUiState

@Composable
internal fun AuthRoute(
    padding: PaddingValues,
    navigateHome: () -> Unit,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    AuthScreen(
        padding = padding,
        uiState = uiState.value,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange =  viewModel::onPasswordChange,
        onLoginClick = viewModel::login,
        onSignupClick = {},
        onLoginSuccess = navigateHome
    )
}

@Composable
private fun AuthScreen(
    padding: PaddingValues,
    uiState: AuthUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onSignupClick: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(padding)
            .padding(Dimens.common)
            .fillMaxSize(),
    ) {
        when(uiState){
            is AuthUiState.Login -> {
                LoginContent(
                    email = uiState.email,
                    password = uiState.password,
                    onEmailChange = onEmailChange,
                    onPasswordChange =  onPasswordChange,
                    onLoginClick = onLoginClick,
                    onSignupClick = {},
                )
            }
            is AuthUiState.OnLogin -> {
                onLoginSuccess()
            }
            else -> {}
        }
    }
}
