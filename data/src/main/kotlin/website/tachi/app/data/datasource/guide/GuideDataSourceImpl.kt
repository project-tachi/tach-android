package website.tachi.app.data.datasource.guide

import website.tachi.app.data.network.TachiApiService
import website.tachi.app.data.network.model.GuideData
import javax.inject.Inject

class GuideDataSourceImpl @Inject constructor(private val tachiApiService: TachiApiService) :
    GuideDataSource {
    override suspend fun getGuide(id: Long): GuideData {
        return tachiApiService.getGuide(id).data!!
    }
}