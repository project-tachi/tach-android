package website.tachi.app.data.network.model

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("id")
    val id: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("profilePicture")
    val profilePicture: Any?,
    @SerializedName("createdTime")
    val createdTime: String?
)