package website.tachi.app.data.datasource.reviews

import website.tachi.app.data.network.model.ReviewData

interface ReviewDataSource {
    suspend fun getSpotReviews(spotId: Long): List<ReviewData>
    suspend fun getGuideReviews(guideId: Long): List<ReviewData>
}