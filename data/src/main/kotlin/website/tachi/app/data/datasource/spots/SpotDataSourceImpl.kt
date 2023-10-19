package website.tachi.app.data.datasource.spots

import website.tachi.app.data.network.TachiApiService
import website.tachi.app.data.network.model.SpotData
import javax.inject.Inject

class SpotDataSourceImpl @Inject constructor(private val tachiApiService: TachiApiService) :
    SpotDataSource {
    override suspend fun getSpot(id: Long): SpotData {
        return tachiApiService.getSpot(id).data!!
    }
}