package website.tachi.app.domain.usecase

import website.tachi.app.domain.model.Spot
import website.tachi.app.domain.repository.SpotRepository
import javax.inject.Inject

class GetSpotUseCase @Inject constructor(private val spotRepository: SpotRepository) {
    suspend operator fun invoke(spotId: Long): Spot {
        return spotRepository.getSpot(spotId)
    }
}