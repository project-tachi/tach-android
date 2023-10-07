package website.tachi.app.data.datasource.auth

interface AuthTokenDataSource {
    suspend fun createCustomToken(accessToken : String) : String
}