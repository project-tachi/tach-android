package website.tachi.app.data.network.model

import com.google.gson.annotations.SerializedName

data class RecommendationTypeData(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("preferenceStartTime")
    val preferenceStartTime: String?,
    @SerializedName("preferenceEndTime")
    val preferenceEndTime: String?,
    @SerializedName("allowedDistance")
    val allowedDistance: Int?,
    @SerializedName("preference")
    val preference: PreferenceData?
)