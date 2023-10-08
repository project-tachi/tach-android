package website.tachi.app.data.repository.search

import website.tachi.app.data.datasource.festival.FestivalDataSource
import website.tachi.app.data.datasource.keyword.KeywordDataSource
import website.tachi.app.data.datasource.preference.SearchPreferenceDataSource
import website.tachi.app.data.network.mapper.toDomain
import website.tachi.app.domain.model.Festival
import website.tachi.app.domain.model.Keyword
import website.tachi.app.domain.model.Preference
import website.tachi.app.domain.repository.SearchConditionRepository

class SearchConditionRepositoryImpl(
    private val keywordDataSource: KeywordDataSource,
    private val festivalDataSource: FestivalDataSource,
    private val searchPreferenceDataSource: SearchPreferenceDataSource
) : SearchConditionRepository {
    override suspend fun getFestivals(): List<Festival> {
        return festivalDataSource.getFestivals().map {
            it.toDomain()
        }
    }

    override suspend fun getKeywords(): List<Keyword> {
        return keywordDataSource.getKeywords().map {
            it.toDomain()
        }
    }

    override suspend fun getPreferences(): List<Preference> {
        return searchPreferenceDataSource.getSearchPreferences().map {
            it.toDomain()
        }
    }
}