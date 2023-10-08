package website.tachi.app.domain.repository

import website.tachi.app.domain.model.Preference

interface PreferenceRepository {
    suspend fun getPreferences(): List<Preference>
}