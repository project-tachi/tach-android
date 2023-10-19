package website.tachi.app.domain.model

import java.util.Date

data class Schedule(
    val type: String,
    val spotData: Spot?,
    val festival: Festival?,
    val recommendedTime: Date
)

fun Schedule.getName() : String{
    return spotData?.name ?: festival?.name ?: ""
}
fun Schedule.getLatitude() : Double{
    return spotData?.latitude ?: festival?.latitude ?: 0.0
}

fun Schedule.getLongitude() : Double{
    return spotData?.longitude ?: festival?.longitude ?: 0.0
}
