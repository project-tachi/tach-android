package website.tachi.app.domain.repository

import website.tachi.app.domain.model.Spot

interface SpotRepository {
    suspend fun getSpot(spotId: Long): Spot
}