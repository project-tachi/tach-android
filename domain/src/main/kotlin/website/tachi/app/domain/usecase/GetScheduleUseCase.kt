package website.tachi.app.domain.usecase

import website.tachi.app.domain.model.Schedule
import website.tachi.app.domain.model.ScheduleResponse
import website.tachi.app.domain.repository.ScheduleRepository
import javax.inject.Inject
import javax.sql.CommonDataSource

class GetScheduleUseCase @Inject constructor(private val scheduleRepository: ScheduleRepository) {
    suspend operator fun invoke(
        preferenceId: String?,
        festivalId: String?,
        keywordId: String?,
        travelDuration: String,
        latitude: Double,
        longitude: Double
    ): ScheduleResponse {
        return scheduleRepository.getSchedule(preferenceId, festivalId, keywordId, travelDuration, latitude, longitude)
    }
}