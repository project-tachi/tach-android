package website.tachi.app.data.network.mapper

import website.tachi.app.data.network.model.ScheduleData
import website.tachi.app.domain.model.Schedule

fun ScheduleData.toDomain(): Schedule {
    return Schedule(
        type = type ?: throw IllegalArgumentException("type cannot be null"),
        spotData = spotData?.toDomain(),
        festival = festival?.toDomain(),
        recommendedTime = recommendedTime?.let { dateFormat.parse(it) } ?: throw IllegalArgumentException("recommendedTime cannot be null")
    )
}