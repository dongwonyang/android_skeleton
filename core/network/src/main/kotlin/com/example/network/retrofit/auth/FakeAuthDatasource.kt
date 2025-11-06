package com.example.network.retrofit.auth

import com.example.network.datasource.AuthDatasource
import com.example.network.model.ApiResponse
import com.example.network.model.response.LoginResponse
import javax.inject.Singleton

@Singleton
class FakeAuthDatasource: AuthDatasource {
    override suspend fun login(email: String, password: String): ApiResponse<LoginResponse> {
        return ApiResponse.Success(LoginResponse(true))
    }
}