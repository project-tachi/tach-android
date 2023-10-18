package website.tachi.app.data.network.mapper

import website.tachi.app.data.network.model.TourismAreaData
import website.tachi.app.data.util.parseJsonToListOfString
import website.tachi.app.domain.model.TourismArea

fun TourismAreaData.toDomain() : TourismArea {
    return TourismArea(this.id, this.name, this.latitude, this.longitude, this.imageUrls.parseJsonToListOfString())
}