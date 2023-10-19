package website.tachi.app.data.datasource.mainbg

import website.tachi.app.data.network.TachiApiService
import javax.inject.Inject

class MainBackgroundImageUrlDataSourceImpl @Inject constructor(private val tachiApiService: TachiApiService) : MainBackgroundImageUrlDataSource {
    override suspend fun getMainBackgroundImageUrl(): String {
        return tachiApiService.getMainBackgroundImage().data!!
    }
}