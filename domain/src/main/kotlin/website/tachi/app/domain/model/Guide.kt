package website.tachi.app.domain.model

import java.util.Date

data class Guide(
    val id: Int?,
    val introduction: String?,
    val userData: User,
    val tourismArea: TourismArea,
    val education: String?,
    val languageProficiency: String?,
    val createdTime: Date
)