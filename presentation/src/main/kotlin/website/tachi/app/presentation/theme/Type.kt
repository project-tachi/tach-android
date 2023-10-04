package website.tachi.app.presentation.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import website.tachi.app.presentation.R

val Pretendard = FontFamily(
    Font(R.font.pretendardbold, FontWeight.Bold),
    Font(R.font.pretendardsemibold, FontWeight.SemiBold),
    Font(R.font.pretendardmedium, FontWeight.Medium),
    Font(R.font.pretendardregular, FontWeight.Normal),
)

val BaseTextStyle = TextStyle(fontFamily = Pretendard)

val typography = AppTypography(
    headline = TextStyle(
        fontFamily = Pretendard,
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
    body = BaseTextStyle.copy(

    ),
    title = TextStyle(fontSize = 32.sp)
)

