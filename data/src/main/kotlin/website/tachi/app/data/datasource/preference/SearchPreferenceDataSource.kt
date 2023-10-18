package website.tachi.app.data.datasource.preference

import website.tachi.app.data.network.model.PreferenceData

interface SearchPreferenceDataSource {
    suspend fun getSearchPreferences() : List<PreferenceData>
}