package website.tachi.app.presentation.utils

import java.text.SimpleDateFormat
import java.util.Date

fun formatDateRange(startTime: Date, endTime: Date): String {
    val formatter = SimpleDateFormat("MM . dd")
    return "${formatter.format(startTime)} ~ ${formatter.format(endTime)}"
}