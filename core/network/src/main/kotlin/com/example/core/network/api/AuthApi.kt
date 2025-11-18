package com.example.core.network.api

import com.example.core.network.model.response.LoginResponse
import retrofit2.Response

interface AuthApi {
    suspend fun login(email: String, password: String): Response<LoginResponse>
}