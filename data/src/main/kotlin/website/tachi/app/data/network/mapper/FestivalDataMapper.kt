package website.tachi.app.data.network.mapper

import website.tachi.app.data.network.model.FestivalData
import website.tachi.app.domain.model.Festival
import website.tachi.app.domain.util.toDate

fun FestivalData.toDomain(): Festival {
    return Festival(
        this.id,
        this.name,
        this.content,
        this.location,
        this.roadAddress,
        this.address,
        this.latitude,
        this.longitude,
        this.startTime.toDate()!!,
        this.endTime.toDate()!!,
        this.imageUrls,
        this.tourismArea.toDomain()
    )
}