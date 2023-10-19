package website.tachi.app.data.repository.spot

import website.tachi.app.data.datasource.spots.SpotDataSource
import website.tachi.app.data.network.mapper.toDomain
import website.tachi.app.data.network.model.SpotData
import website.tachi.app.domain.model.Spot
import website.tachi.app.domain.repository.SpotRepository
import javax.inject.Inject

class SpotRepositoryImpl @Inject constructor(private val spotDataSource : SpotDataSource) : SpotRepository {
    override suspend fun getSpot(spotId: Long): Spot {
        return spotDataSource.getSpot(spotId).toDomain()
    }

}