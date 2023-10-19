package website.tachi.app.data.network.mapper

import website.tachi.app.data.network.model.GuideData
import website.tachi.app.domain.model.Guide
import java.text.SimpleDateFormat
import java.util.Locale

val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

fun GuideData.toDomain(): Guide {
    return Guide(
        id = id,
        introduction = introduction,
        userData = userData?.toDomain() ?: throw IllegalArgumentException("userData cannot be null"),
        tourismArea = tourismArea?.toDomain() ?: throw IllegalArgumentException("tourismArea cannot be null"),
        education = education,
        languageProficiency = languageProficiency,
        createdTime = createdTime?.let { dateFormat.parse(it) } ?: throw IllegalArgumentException("createdTime cannot be null")
    )
}