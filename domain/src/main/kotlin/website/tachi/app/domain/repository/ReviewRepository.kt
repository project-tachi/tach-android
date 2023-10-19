package website.tachi.app.domain.repository

import website.tachi.app.domain.model.Review


interface ReviewRepository {
    suspend fun getSpotReviews(spotId: Long): List<Review>
    suspend fun getGuideReviews(guideId: Long): List<Review>
}