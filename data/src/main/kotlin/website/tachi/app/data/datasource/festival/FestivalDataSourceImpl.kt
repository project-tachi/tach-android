package website.tachi.app.data.datasource.festival

import website.tachi.app.data.network.TachiApiService
import website.tachi.app.data.network.model.FestivalData
import javax.inject.Inject

class FestivalDataSourceImpl @Inject constructor(private val tachiApiService: TachiApiService) : FestivalDataSource {
    override suspend fun getFestivals(): List<FestivalData> {
        return tachiApiService.getAllFestivals().data!!
    }
}