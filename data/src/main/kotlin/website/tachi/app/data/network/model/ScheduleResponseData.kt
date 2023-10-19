package website.tachi.app.data.network.model

import com.google.gson.annotations.SerializedName

data class ScheduleResponseData(
    @SerializedName("guides")
    val guideData: List<GuideData>,
    @SerializedName("schedules")
    val scheduleData: List<ScheduleData>
)
