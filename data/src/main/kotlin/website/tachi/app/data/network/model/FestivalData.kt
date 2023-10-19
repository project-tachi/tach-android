package website.tachi.app.data.network.model

import com.google.gson.annotations.SerializedName

data class FestivalData(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("roadAddress")
    val roadAddress: Any?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("startTime")
    val startTime: String?,
    @SerializedName("endTime")
    val endTime: String?,
    @SerializedName("imageUrls")
    val imageUrls: String?,
    @SerializedName("tourismArea")
    val tourismArea: TourismAreaData?  // TourismAreaData 라는 이름으로 가정
)