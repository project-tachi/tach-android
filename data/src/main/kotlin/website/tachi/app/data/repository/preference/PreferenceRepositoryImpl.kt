package website.tachi.app.data.repository.preference

import website.tachi.app.data.datasource.preference.SearchPreferenceDataSource
import website.tachi.app.data.network.mapper.toDomain
import website.tachi.app.domain.model.Preference
import website.tachi.app.domain.repository.PreferenceRepository

class PreferenceRepositoryImpl(
    private val searchPreferenceDataSource: SearchPreferenceDataSource
) : PreferenceRepository {
    override suspend fun getPreferences(): List<Preference> {
        return searchPreferenceDataSource.getSearchPreferences().map {
            it.toDomain()
        }
    }
}