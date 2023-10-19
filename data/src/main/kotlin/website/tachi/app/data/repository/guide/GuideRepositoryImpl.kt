package website.tachi.app.data.repository.guide

import website.tachi.app.data.datasource.guide.GuideDataSource
import website.tachi.app.data.network.mapper.toDomain
import website.tachi.app.data.network.model.GuideData
import website.tachi.app.domain.model.Guide
import website.tachi.app.domain.repository.GuideRepository
import javax.inject.Inject

class GuideRepositoryImpl @Inject constructor(private val guideDataSource: GuideDataSource) :
    GuideRepository {
    override suspend fun getGuide(guideId: Long): Guide {
        return guideDataSource.getGuide(guideId).toDomain()
    }

}