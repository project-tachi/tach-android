package website.tachi.app.domain.usecase

import website.tachi.app.domain.model.Guide
import website.tachi.app.domain.repository.GuideRepository
import javax.inject.Inject

class GetGuideUseCase @Inject constructor(private val guideRepository: GuideRepository) {
    suspend operator fun invoke(guideId: Long): Guide {
        return guideRepository.getGuide(guideId)
    }
}