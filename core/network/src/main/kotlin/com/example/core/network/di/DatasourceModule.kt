package com.example.core.network.di

import com.example.core.network.datasource.auth.AuthDatasource
import com.example.core.network.datasource.auth.FakeAuthDatasource
import com.example.core.network.datasource.auth.RetrofitAuthDatasource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DatasourceModule {
    @Binds
    @FakeDataSource
    abstract fun bindFakeAuthDatasource(
        fakeAuthDatasource: FakeAuthDatasource
    ): AuthDatasource

    @Binds
    @RealDataSource
    abstract fun bindAuthDatasource(
        retrofitAuthDatasource: RetrofitAuthDatasource
    ): AuthDatasource

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RealDataSource

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakeDataSource