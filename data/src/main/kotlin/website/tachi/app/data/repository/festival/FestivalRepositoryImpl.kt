package website.tachi.app.data.repository.festival

import website.tachi.app.data.datasource.festival.FestivalDataSource
import website.tachi.app.data.network.mapper.toDomain
import website.tachi.app.domain.model.Festival
import website.tachi.app.domain.repository.FestivalRepository
import javax.inject.Inject

class FestivalRepositoryImpl @Inject constructor(private val festivalDataSource: FestivalDataSource) : FestivalRepository {
    override suspend fun getFestivals(): List<Festival> {
        return festivalDataSource.getFestivals().map {
            it.toDomain()
        }
    }
}