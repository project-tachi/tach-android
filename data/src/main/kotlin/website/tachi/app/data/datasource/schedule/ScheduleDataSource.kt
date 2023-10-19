package website.tachi.app.data.datasource.schedule

import website.tachi.app.data.network.model.ScheduleResponseData

interface ScheduleDataSource {
    suspend fun getSchedule(
        preferenceId: String?,
        festivalId: String?,
        keywordId: String?,
        travelDuration: String,
        latitude: Double,
        longitude: Double
    ): ScheduleResponseData
}