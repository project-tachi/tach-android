package website.tachi.app.domain.repository

interface MainBackgroundImageRepository {
    suspend fun getMainBackgroundImageUrl(): String
}