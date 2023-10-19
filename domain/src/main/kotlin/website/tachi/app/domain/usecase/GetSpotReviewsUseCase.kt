package website.tachi.app.domain.usecase

import website.tachi.app.domain.model.Review
import website.tachi.app.domain.repository.ReviewRepository
import javax.inject.Inject

class GetSpotReviewsUseCase @Inject constructor(private val reviewRepository: ReviewRepository) {
    suspend operator fun invoke(spotId: Long): List<Review> {
        return reviewRepository.getSpotReviews(spotId)
    }
}