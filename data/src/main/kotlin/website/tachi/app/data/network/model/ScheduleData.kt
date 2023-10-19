package website.tachi.app.data.network.model

import com.google.gson.annotations.SerializedName

data class ScheduleData(
    @SerializedName("type")
    val type: String?,
    @SerializedName("spot")
    val spotData: SpotData?,
    @SerializedName("festival")
    val festival: FestivalData?,
    @SerializedName("recommendedTime")
    val recommendedTime: String?
)