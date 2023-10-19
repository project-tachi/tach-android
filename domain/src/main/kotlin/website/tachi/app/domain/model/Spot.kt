package website.tachi.app.domain.model

data class Spot(
    val id: Int,
    val name: String,
    val content: String,
    val roadAddress: String,
    val address: String,
    val imageUrls: String?,
    val latitude: Double,
    val longitude: Double,
    val parkingSupported: Boolean?,
    val tourismArea: TourismArea,
    val recommendationType: RecommendationType,
    val category: Category
)
