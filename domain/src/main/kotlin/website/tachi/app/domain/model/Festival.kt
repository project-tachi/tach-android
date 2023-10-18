package website.tachi.app.domain.model

import java.util.Date

data class Festival(
    val id: Long,
    val name: String,
    val content: String,
    val location: String,
    val roadAddress: String?,
    val address: String?,
    val latitude: Double,
    val longitude: Double,
    val startTime: Date,
    val endTime: Date,
    val imageUrls: List<String>,
    val tourismArea: TourismArea
)