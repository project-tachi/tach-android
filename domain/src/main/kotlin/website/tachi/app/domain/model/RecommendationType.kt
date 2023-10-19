package website.tachi.app.domain.model

import java.util.Date

data class RecommendationType(
    val id: Int,
    val preferenceStartTime: Date,
    val preferenceEndTime: Date,
    val allowedDistance: Int,
    val preference: Preference
)