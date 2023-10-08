package website.tachi.app.data.network.model

data class TourismAreaData(
    val id: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val imageUrls: List<String>
)