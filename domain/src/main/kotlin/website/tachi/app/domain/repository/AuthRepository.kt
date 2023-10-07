package website.tachi.app.domain.repository

interface AuthRepository {
    suspend fun signInWithAuthToken(token : String) : String
}