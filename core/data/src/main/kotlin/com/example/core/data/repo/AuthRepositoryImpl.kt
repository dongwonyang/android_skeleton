package com.example.core.data.repo

import com.example.core.data.mapper.toResult
import com.example.core.network.datasource.auth.AuthDatasource
import com.example.core.network.di.FakeDataSource
import com.example.core.network.model.response.LoginResponse
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
    @param:FakeDataSource private val authDatasource: AuthDatasource
): AuthRepository {
    override suspend fun login(email: String, password: String): Result<Boolean> {
        return authDatasource.login(email, password).toResult(
            transform = {
                it.isSuccess
            }
        )
    }
}