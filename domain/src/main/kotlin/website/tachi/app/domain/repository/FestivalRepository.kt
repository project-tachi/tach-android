package website.tachi.app.domain.repository

import website.tachi.app.domain.model.Festival

interface FestivalRepository {
    suspend fun getFestivals(): List<Festival>
}