package website.tachi.app.domain.repository

import website.tachi.app.domain.model.SchedulePlace

interface ScheduleRepository {

    suspend fun getSchedule(
        preferenceId: String?,
        festivalId: String?,
        keywordId: String?,
        travelDuration: String,
        latitude: Double,
        longitude: Double
    ) : List<SchedulePlace>
}