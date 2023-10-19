package website.tachi.app.domain.model

import java.util.Date

data class Review(
    val id: Int,
    val rating: Double,
    val content: String,
    val user: User,
    val createdTime: Date,
    val updatedTime: Date
)