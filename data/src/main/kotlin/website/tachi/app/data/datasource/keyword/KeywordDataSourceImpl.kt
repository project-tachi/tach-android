package website.tachi.app.data.datasource.keyword

import website.tachi.app.data.network.TachiApiService
import website.tachi.app.data.network.model.KeywordData
import javax.inject.Inject

class KeywordDataSourceImpl @Inject constructor(private val tachiApiService: TachiApiService) : KeywordDataSource {
    override suspend fun getKeywords(): List<KeywordData> {
        return tachiApiService.getAllKeywords().data!!
    }
}