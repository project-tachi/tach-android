package website.tachi.app.domain.repository

import website.tachi.app.domain.model.Keyword

interface KeywordRepository {
    suspend fun getKeywords(): List<Keyword>
}