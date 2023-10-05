package website.tachi.app.presentation.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import website.tachi.app.presentation.R

val Pretendard = FontFamily(
    Font(R.font.pretendardbold, FontWeight.Bold),
    Font(R.font.pretendardsemibold, FontWeight.SemiBold),
    Font(R.font.pretendardmedium, FontWeight.Medium),
    Font(R.font.pretendardregular, FontWeight.Normal),
)

val GmarketSans = FontFamily(
    Font(R.font.gmarketsansbold, FontWeight.Bold),
    Font(R.font.gmarketsanslight, FontWeight.Light),
    Font(R.font.gmarketsansmedium, FontWeight.Medium),
)

val BaseTextStyle = TextStyle(fontFamily = Pretendard)

val typography = AppTypography(
    headline = TextStyle(
        fontFamily = GmarketSans,
        fontSize = 23.sp,
        fontWeight = FontWeight(700),
        color = Color(0xFF000000),
    ),
    subHeadline = TextStyle(
        fontFamily = Pretendard,
        fontSize = 13.sp,
        fontWeight = FontWeight(500),
        color = Color(0x99000000),
    ),
    gmarketSansBody = BaseTextStyle.copy(
        fontFamily = GmarketSans
    ),
    pretendardBody = BaseTextStyle.copy(),
    title = TextStyle(fontSize = 32.sp)
)

