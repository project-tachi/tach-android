package website.tachi.app.data.network.model

import com.google.gson.annotations.SerializedName

data class ReviewData(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("content")
    val content: String,
    @SerializedName("user")
    val user: UserData,
    @SerializedName("createdTime")
    val createdTime: String,
    @SerializedName("updatedTime")
    val updatedTime: String
)