package website.tachi.app.data.repository.review

import website.tachi.app.data.datasource.reviews.ReviewDataSource
import website.tachi.app.data.network.mapper.toDomain
import website.tachi.app.domain.model.Review
import website.tachi.app.domain.repository.ReviewRepository
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(private val reviewDataSource: ReviewDataSource) :
    ReviewRepository {
    override suspend fun getSpotReviews(spotId: Long): List<Review> {
        return reviewDataSource.getSpotReviews(spotId).map {
            it.toDomain()
        }
    }

    override suspend fun getGuideReviews(guideId: Long): List<Review> {
        return reviewDataSource.getGuideReviews(guideId).map {
            it.toDomain()
        }
    }

}