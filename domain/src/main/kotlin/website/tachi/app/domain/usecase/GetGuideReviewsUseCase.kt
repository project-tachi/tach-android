package website.tachi.app.domain.usecase

import website.tachi.app.domain.model.Review
import website.tachi.app.domain.repository.ReviewRepository
import javax.inject.Inject

class GetGuideReviewsUseCase @Inject constructor(private val reviewRepository: ReviewRepository) {
    suspend operator fun invoke(guideId: Long): List<Review> {
        return reviewRepository.getGuideReviews(guideId)
    }
}