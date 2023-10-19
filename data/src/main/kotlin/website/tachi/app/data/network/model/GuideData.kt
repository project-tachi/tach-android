package website.tachi.app.data.network.model

import com.google.gson.annotations.SerializedName

data class GuideData(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("introduction")
    val introduction: String?,
    @SerializedName("user")
    val userData: UserData?,
    @SerializedName("tourismArea")
    val tourismArea: TourismAreaData?,
    @SerializedName("education")
    val education: String?,
    @SerializedName("languageProficiency")
    val languageProficiency: String?,
    @SerializedName("createdTime")
    val createdTime: String?
)