package website.tachi.app.data.datasource.preference

import website.tachi.app.data.network.TachiApiService
import website.tachi.app.data.network.model.PreferenceData
import javax.inject.Inject

class SearchPreferenceDataSourceImpl @Inject constructor(private val tachiApiService: TachiApiService) :
    SearchPreferenceDataSource {
    override suspend fun getSearchPreferences(): List<PreferenceData> {
        return tachiApiService.getAllPreferences().data!!
    }
}