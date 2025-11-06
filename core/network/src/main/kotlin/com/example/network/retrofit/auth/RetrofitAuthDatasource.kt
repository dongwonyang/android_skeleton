package com.example.network.retrofit.auth

import com.example.network.api.AuthApi
import com.example.network.datasource.AuthDatasource
import com.example.network.model.ApiResponse
import com.example.network.model.response.LoginResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitAuthDatasource @Inject constructor(
    authApi: AuthApi
): AuthDatasource {
    override suspend fun login(email: String, password: String): ApiResponse<LoginResponse> {
        TODO("Not yet implemented")
    }
}