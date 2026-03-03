package com.example.core.domain.uscecase

import com.example.core.data.repo.AuthRepository
import jakarta.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun login(email: String, password: String): Result<Boolean> {
        return authRepository.login(email, password)
    }
}