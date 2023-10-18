package website.tachi.app.data.repository.keyword

import website.tachi.app.data.datasource.keyword.KeywordDataSource
import website.tachi.app.data.network.mapper.toDomain
import website.tachi.app.domain.model.Keyword
import website.tachi.app.domain.repository.KeywordRepository
import javax.inject.Inject

class KeywordRepositoryImpl @Inject constructor(private val keywordDataSource: KeywordDataSource) :
    KeywordRepository {
    override suspend fun getKeywords(): List<Keyword> {
        return keywordDataSource.getKeywords().map {
            it.toDomain()
        }
    }
}