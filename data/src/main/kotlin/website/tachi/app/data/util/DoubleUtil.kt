package website.tachi.app.data.util

fun Double.roundToTwoDecimalPlaces(): Double {
    return kotlin.math.round(this * 100) / 100
}

fun Double.truncateToTwoDecimalPlaces(): Double {
    return (this * 100).toInt() / 100.0
}
