package website.tachi.app.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import website.tachi.app.data.datasource.auth.AuthDataSource
import website.tachi.app.data.datasource.auth.AuthDataSourceImpl
import website.tachi.app.data.datasource.auth.AuthTokenDataSource
import website.tachi.app.data.datasource.auth.AuthTokenDataSourceImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindAuthDataSource(source : AuthDataSourceImpl) : AuthDataSource

    @Binds
    @Singleton
    abstract fun bindAuthTokenDataSource(source : AuthTokenDataSourceImpl) : AuthTokenDataSource
}