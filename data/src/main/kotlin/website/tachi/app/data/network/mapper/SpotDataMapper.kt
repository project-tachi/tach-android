package website.tachi.app.data.network.mapper

import website.tachi.app.data.network.model.SpotData
import website.tachi.app.domain.model.Spot

fun SpotData.toDomain(): Spot {
    return Spot(
        id = id ?: 0,  // 기본값은 0이지만, 필요에 따라 다르게 설정할 수 있습니다.
        name = name.orEmpty(),
        content = content?.toString().orEmpty(),
        roadAddress = roadAddress.orEmpty(),
        address = address.orEmpty(),
        imageUrls = imageUrls,
        latitude = latitude ?: 0.0,  // 기본값은 0.0이지만, 필요에 따라 다르게 설정할 수 있습니다.
        longitude = longitude ?: 0.0,  // 기본값은 0.0이지만, 필요에 따라 다르게 설정할 수 있습니다.
        parkingSupported = parkingSupported,
        tourismArea = tourismArea?.toDomain() ?: throw IllegalArgumentException("tourismArea cannot be null"),  // 예외 처리 방식은 필요에 따라 조절 가능합니다.
        recommendationType = recommendationTypeData?.toDomain() ?: throw IllegalArgumentException("recommendationTypeData cannot be null"),  // 예외 처리 방식은 필요에 따라 조절 가능합니다.
        category = category?.toDomain() ?: throw IllegalArgumentException("category cannot be null")  // 예외 처리 방식은 필요에 따라 조절 가능합니다.
    )
}