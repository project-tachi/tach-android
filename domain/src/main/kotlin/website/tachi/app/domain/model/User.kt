package website.tachi.app.domain.model

import java.util.Date

data class User(
    val id: String,
    val email: String,
    val name: String,
    val profilePicture: String?,
    val createdTime: Date
)