package com.example.core.network.datasource.auth

import com.example.core.network.model.ApiResponse
import com.example.core.network.model.response.LoginResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeAuthDatasource @Inject constructor(): AuthDatasource {
    override suspend fun login(email: String, password: String): ApiResponse<LoginResponse> {
        return ApiResponse.Success(LoginResponse(true))
    }
}