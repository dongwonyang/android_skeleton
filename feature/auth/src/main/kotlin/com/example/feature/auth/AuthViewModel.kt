package com.example.feature.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.repo.AuthRepository
import com.example.feature.auth.model.AuthUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<AuthUiState> = MutableStateFlow(AuthUiState.Login())
    val uiState: StateFlow<AuthUiState> = _uiState


    fun login() = viewModelScope.launch{
        (uiState.value as? AuthUiState.Login)?.let{
            authRepository.login(it.email, it.password).onSuccess{
                if(it) _uiState.update{ AuthUiState.OnLogin}
            }.onFailure {  }
        }
    }

    fun onEmailChange(email: String) {
        (_uiState as? MutableStateFlow<AuthUiState.Login>)?.update { prev ->
            prev.copy(email = email)
        }
    }

    fun onPasswordChange(password: String) {
        (_uiState as? MutableStateFlow<AuthUiState.Login>)?.update { prev ->
            prev.copy(password = password)
        }
    }


}