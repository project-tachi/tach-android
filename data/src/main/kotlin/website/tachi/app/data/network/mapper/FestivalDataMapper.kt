package website.tachi.app.data.network.mapper

import com.google.gson.Gson
import website.tachi.app.data.network.model.FestivalData
import website.tachi.app.data.util.parseJsonToListOfString
import website.tachi.app.domain.model.Festival
import website.tachi.app.domain.util.toDate

fun FestivalData.toDomain(): Festival {
    return Festival(
        id = id ?: throw IllegalArgumentException("id cannot be null"),
        name = name ?: throw IllegalArgumentException("name cannot be null"),
        content = content ?: throw IllegalArgumentException("content cannot be null"),
        location = location ?: throw IllegalArgumentException("location cannot be null"),
        roadAddress = roadAddress?.toString(),
        address = address,
        latitude = latitude ?: throw IllegalArgumentException("latitude cannot be null"),
        longitude = longitude ?: throw IllegalArgumentException("longitude cannot be null"),
        startTime = startTime?.let { dateFormat.parse(it) }
            ?: throw IllegalArgumentException("startTime cannot be null"),
        endTime = endTime?.let { dateFormat.parse(it) }
            ?: throw IllegalArgumentException("endTime cannot be null"),
        imageUrls = this.imageUrls?.parseJsonToListOfString() ?: listOf(),
        tourismArea = tourismArea?.toDomain()
            ?: throw IllegalArgumentException("tourismArea cannot be null")
    )
}