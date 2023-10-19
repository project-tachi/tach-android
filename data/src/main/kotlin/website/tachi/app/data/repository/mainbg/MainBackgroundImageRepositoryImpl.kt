package website.tachi.app.data.repository.mainbg

import website.tachi.app.data.datasource.mainbg.MainBackgroundImageUrlDataSource
import website.tachi.app.domain.repository.MainBackgroundImageRepository
import javax.inject.Inject

class MainBackgroundImageRepositoryImpl @Inject constructor(private val mainBackgroundImageUrlDataSource: MainBackgroundImageUrlDataSource) :
    MainBackgroundImageRepository {
    override suspend fun getMainBackgroundImageUrl(): String {
        return mainBackgroundImageUrlDataSource.getMainBackgroundImageUrl()
    }
}