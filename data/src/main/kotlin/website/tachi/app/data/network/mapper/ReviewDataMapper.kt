package website.tachi.app.data.network.mapper

import website.tachi.app.data.network.model.ReviewData
import website.tachi.app.domain.model.Review

fun ReviewData.toDomain(): Review {
    return Review(
        id = id ?: throw IllegalArgumentException("id cannot be null"),
        rating = rating,
        content = content,
        user = user.toDomain(),
        createdTime = dateFormat.parse(createdTime) ?: throw IllegalArgumentException("createdTime is invalid"),
        updatedTime = dateFormat.parse(updatedTime) ?: throw IllegalArgumentException("updatedTime is invalid")
    )
}