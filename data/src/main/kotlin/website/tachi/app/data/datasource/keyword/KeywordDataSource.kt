package website.tachi.app.data.datasource.keyword

import website.tachi.app.data.network.model.KeywordData
import website.tachi.app.domain.model.Keyword

interface KeywordDataSource {
    suspend fun getKeywords() : List<KeywordData>
}