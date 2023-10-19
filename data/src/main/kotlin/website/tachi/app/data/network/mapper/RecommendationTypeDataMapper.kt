package website.tachi.app.data.network.mapper

import website.tachi.app.data.network.model.RecommendationTypeData
import website.tachi.app.domain.model.RecommendationType

fun RecommendationTypeData.toDomain(): RecommendationType {
    return RecommendationType(
        id = id ?: throw IllegalArgumentException("id cannot be null"),
        preferenceStartTime = preferenceStartTime?.let { dateFormat.parse(it) } ?: throw IllegalArgumentException("preferenceStartTime cannot be null"),
        preferenceEndTime = preferenceEndTime?.let { dateFormat.parse(it) } ?: throw IllegalArgumentException("preferenceEndTime cannot be null"),
        allowedDistance = allowedDistance ?: throw IllegalArgumentException("allowedDistance cannot be null"),
        preference = preference?.toDomain() ?: throw IllegalArgumentException("preference cannot be null")
    )
}