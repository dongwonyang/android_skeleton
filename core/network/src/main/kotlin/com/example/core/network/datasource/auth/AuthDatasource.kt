package com.example.core.network.datasource.auth

import com.example.core.network.model.ApiResponse
import com.example.core.network.model.response.LoginResponse

interface AuthDatasource {
    suspend fun login(email: String, password: String): ApiResponse<LoginResponse>
}