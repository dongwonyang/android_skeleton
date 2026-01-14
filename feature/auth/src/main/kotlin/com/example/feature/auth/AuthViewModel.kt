package com.example.feature.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.repo.AuthRepository
import com.example.feature.auth.model.AuthEffect
import com.example.feature.auth.model.AuthEvent
import com.example.feature.auth.model.AuthUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<AuthUiState> = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState

    private val _effect = Channel<AuthEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.EmailChanged -> {
                _uiState.update { it.copy(email = event.value) }
            }

            is AuthEvent.PasswordChanged -> {
                _uiState.update { it.copy(password = event.value) }
            }

            AuthEvent.LoginClicked -> login()
            AuthEvent.SignupClicked -> {
                viewModelScope.launch { _effect.send(AuthEffect.ShowSnackBar("준비 중입니다")) }
            }
        }
    }


    fun login() = viewModelScope.launch {
        uiState.value.let {
            authRepository.login(it.email, it.password).onSuccess {
                _effect.send(AuthEffect.NavigateHome)
            }.onFailure { }
        }
    }

    fun onEmailChange(email: String) {
        _uiState.update { prev ->
            prev.copy(email = email)
        }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { prev ->
            prev.copy(password = password)
        }
    }

}