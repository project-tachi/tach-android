package website.tachi.app.data.datasource.schedule

import website.tachi.app.data.network.TachiApiService
import website.tachi.app.data.network.model.ScheduleResponseData
import javax.inject.Inject

class ScheduleDataSourceImpl @Inject constructor(private val tachiApiService: TachiApiService) : ScheduleDataSource {
    override suspend fun getSchedule(
        preferenceId: String?,
        festivalId: String?,
        keywordId: String?,
        travelDuration: String,
        latitude: Double,
        longitude: Double
    ): ScheduleResponseData {
        return tachiApiService.getSchedule(
            preferenceId,
            festivalId,
            keywordId,
            travelDuration,
            latitude,
            longitude
        ).data!!
    }
}