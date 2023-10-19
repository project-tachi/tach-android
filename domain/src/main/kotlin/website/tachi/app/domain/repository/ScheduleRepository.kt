package website.tachi.app.domain.repository

import website.tachi.app.domain.model.Schedule
import website.tachi.app.domain.model.ScheduleResponse

interface ScheduleRepository {

    suspend fun getSchedule(
        preferenceId: String?,
        festivalId: String?,
        keywordId: String?,
        travelDuration: String,
        latitude: Double,
        longitude: Double
    ) : ScheduleResponse
}