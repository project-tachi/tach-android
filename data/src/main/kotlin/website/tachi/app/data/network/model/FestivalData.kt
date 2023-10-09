package website.tachi.app.data.network.model

data class FestivalData(
    val id: Long,
    val name: String,
    val content: String,
    val location: String,
    val roadAddress: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val startTime: String,
    val endTime: String,
    val imageUrls: String,
    val tourismArea: TourismAreaData
)