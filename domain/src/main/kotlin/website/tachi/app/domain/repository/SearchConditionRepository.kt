package website.tachi.app.domain.repository

import website.tachi.app.domain.model.Festival
import website.tachi.app.domain.model.Keyword
import website.tachi.app.domain.model.Preference

interface SearchConditionRepository {
    suspend fun getFestivals(): List<Festival>
    suspend fun getKeywords(): List<Keyword>
    suspend fun getPreferences(): List<Preference>
}