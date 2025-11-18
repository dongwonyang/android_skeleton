package com.example.core.network.datasource.auth

import com.example.core.network.api.AuthApi
import com.example.core.network.datasource.auth.AuthDatasource
import com.example.core.network.model.ApiResponse
import com.example.core.network.model.response.LoginResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitAuthDatasource @Inject constructor(
    authApi: AuthApi
): AuthDatasource {
    override suspend fun login(email: String, password: String): ApiResponse<LoginResponse> {
        return authApi.login(email, password)
    }
}