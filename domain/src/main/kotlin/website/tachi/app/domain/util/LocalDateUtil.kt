package website.tachi.app.domain.util

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

fun String.toDate(): Date? {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    return try {
        format.parse(this)
    } catch (e: Exception) {
        null
    }
}