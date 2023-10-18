package website.tachi.app.domain.usecase

import website.tachi.app.domain.model.SchedulePlace
import website.tachi.app.domain.repository.ScheduleRepository
import javax.inject.Inject

class GetScheduleUseCase @Inject constructor(private val scheduleRepository: ScheduleRepository) {
    suspend operator fun invoke(
        preferenceId: String?,
        festivalId: String?,
        keywordId: String?,
        travelDuration: String,
        latitude: Double,
        longitude: Double
    ): List<SchedulePlace> {
        return scheduleRepository.getSchedule(preferenceId, festivalId, keywordId, travelDuration, latitude, longitude)
    }
}