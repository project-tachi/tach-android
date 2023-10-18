package website.tachi.app.domain.model

import java.util.Date

data class SchedulePlace(
    val name: String,
    val content: String?,
    val roadAddress: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val parkingSupported: Boolean,
    val tourismArea: TourismArea,
    val category: Category,
    val recommendedTime: Date
)