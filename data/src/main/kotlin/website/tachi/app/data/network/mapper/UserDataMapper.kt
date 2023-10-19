package website.tachi.app.data.network.mapper

import website.tachi.app.data.network.model.UserData
import website.tachi.app.domain.model.User
import java.util.Date

fun UserData.toDomain(): User {
    return User(
        id = id ?: throw IllegalArgumentException("id cannot be null"),
        email = email ?: throw IllegalArgumentException("email cannot be null"),
        name = name ?: throw IllegalArgumentException("name cannot be null"),
        profilePicture = profilePicture?.toString(),
        createdTime = createdTime?.let { dateFormat.parse(it) } ?: Date()
    )
}