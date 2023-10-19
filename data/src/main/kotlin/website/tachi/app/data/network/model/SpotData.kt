package website.tachi.app.data.network.model

import com.google.gson.annotations.SerializedName

data class SpotData(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("roadAddress")
    val roadAddress: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("imageUrls")
    val imageUrls: String?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("parkingSupported")
    val parkingSupported: Boolean?,
    @SerializedName("tourismArea")
    val tourismArea: TourismAreaData?,
    @SerializedName("recommendationType")
    val recommendationTypeData: RecommendationTypeData?,
    @SerializedName("category")
    val category: CategoryData?
)
