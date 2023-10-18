package website.tachi.app.data.repository.schedule

import website.tachi.app.data.datasource.schedule.ScheduleDataSource
import website.tachi.app.data.network.mapper.toDomain
import website.tachi.app.domain.model.SchedulePlace
import website.tachi.app.domain.repository.ScheduleRepository
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(private val scheduleDataSource: ScheduleDataSource) : ScheduleRepository {
    override suspend fun getSchedule(
        preferenceId: String?,
        festivalId: String?,
        keywordId: String?,
        travelDuration: String,
        latitude: Double,
        longitude: Double
    ): List<SchedulePlace> {
        return scheduleDataSource.getSchedule(
            preferenceId,
            festivalId,
            keywordId,
            travelDuration,
            latitude,
            longitude
        ).map {
            it.toDomain()
        }
    }
}