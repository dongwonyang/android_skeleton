package com.example.network.datasource

import com.example.network.model.ApiResponse
import com.example.network.model.response.LoginResponse

interface AuthDatasource {
    suspend fun login(email: String, password: String): ApiResponse<LoginResponse>
}