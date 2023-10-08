package website.tachi.app.domain.model

data class TourismArea(
    val id: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val imageUrls: List<String>
)