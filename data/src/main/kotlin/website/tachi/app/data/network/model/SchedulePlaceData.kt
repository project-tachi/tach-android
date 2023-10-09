package website.tachi.app.data.network.model

data class SchedulePlaceData(
    val name: String,
    val content: String?,
    val roadAddress: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val parkingSupported: Boolean,
    val tourismArea: TourismAreaData,
    val category: CategoryData,
    val recommendedTime: String
)