package com.example.core.data.repo

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<Boolean>
}