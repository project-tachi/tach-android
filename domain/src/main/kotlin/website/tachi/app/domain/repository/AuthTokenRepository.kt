package website.tachi.app.domain.repository

interface AuthTokenRepository {
    suspend fun createAuthToken(accessToken : String) : String
}