package website.tachi.app.data.datasource.schedule

import retrofit2.http.Field
import website.tachi.app.data.network.TachiApiService
import website.tachi.app.data.network.model.SchedulePlaceData

interface ScheduleDataSource {
    suspend fun getSchedule(
        preferenceId: String?,
        festivalId: String?,
        keywordId: String?,
        travelDuration: String,
        latitude: Double,
        longitude: Double
    ) : List<SchedulePlaceData>
}