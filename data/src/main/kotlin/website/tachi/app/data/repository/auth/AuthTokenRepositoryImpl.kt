package website.tachi.app.data.repository.auth

import website.tachi.app.data.datasource.auth.AuthTokenDataSource
import website.tachi.app.domain.repository.AuthTokenRepository
import javax.inject.Inject

class AuthTokenRepositoryImpl @Inject constructor(private val authTokenDataSource: AuthTokenDataSource) : AuthTokenRepository{
    override suspend fun createAuthToken(accessToken: String): String {
        return authTokenDataSource.createCustomToken(accessToken)
    }
}