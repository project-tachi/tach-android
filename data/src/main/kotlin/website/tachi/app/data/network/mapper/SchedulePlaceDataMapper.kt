package website.tachi.app.data.network.mapper

import website.tachi.app.data.network.model.SchedulePlaceData
import website.tachi.app.data.network.model.TourismAreaData
import website.tachi.app.data.util.parseJsonToListOfString
import website.tachi.app.domain.model.SchedulePlace
import website.tachi.app.domain.model.TourismArea
import website.tachi.app.domain.util.toDate

fun SchedulePlaceData.toDomain(): SchedulePlace {
    return SchedulePlace(
        this.name,
        this.content,
        this.roadAddress,
        this.address,
        this.latitude,
        this.longitude,
        this.parkingSupported,
        this.tourismArea.toDomain(),
        this.category.toDomain(),
        this.recommendedTime.toDate()!!
    )
}