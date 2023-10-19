package website.tachi.app.data.datasource.reviews

import website.tachi.app.data.network.TachiApiService
import website.tachi.app.data.network.model.ReviewData
import javax.inject.Inject

class ReviewDataSourceImpl @Inject constructor(private val tachiApiService: TachiApiService) : ReviewDataSource{
    override suspend fun getSpotReviews(spotId: Long): List<ReviewData> {
        return tachiApiService.getSpotReviews(spotId).data!!
    }
    override suspend fun getGuideReviews(guideId: Long): List<ReviewData> {
        return tachiApiService.getGuideReviews(guideId).data!!
    }
}