package website.tachi.app.data.datasource.mainbg

interface MainBackgroundImageUrlDataSource {
    suspend fun getMainBackgroundImageUrl(): String
}