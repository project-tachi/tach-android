package website.tachi.app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import website.tachi.app.data.repository.auth.AuthRepositoryImpl
import website.tachi.app.data.repository.auth.AuthTokenRepositoryImpl
import website.tachi.app.domain.repository.AuthRepository
import website.tachi.app.domain.repository.AuthTokenRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(repo: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindAuthTokenRepository(repo: AuthTokenRepositoryImpl): AuthTokenRepository
}