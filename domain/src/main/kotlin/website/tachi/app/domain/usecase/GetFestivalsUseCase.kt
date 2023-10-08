package website.tachi.app.domain.usecase

import website.tachi.app.domain.model.Festival
import website.tachi.app.domain.repository.FestivalRepository
import javax.inject.Inject

class GetFestivalsUseCase @Inject constructor(private val festivalRepository: FestivalRepository) {
    suspend operator fun invoke(): List<Festival> {
        return festivalRepository.getFestivals()
    }
}