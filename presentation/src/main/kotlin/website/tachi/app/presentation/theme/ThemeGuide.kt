package website.tachi.app.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Immutable
data class AppColors(
    val content: Color,
    val component: Color,
    val background: List<Color>
)

@Immutable
data class AppTypography(
    val headline: TextStyle = TextStyle.Default,
    val subHeadline: TextStyle = TextStyle.Default,
    val body: TextStyle = TextStyle.Default,
    val title: TextStyle = TextStyle.Default
)

val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        content = Color.Unspecified,
        component = Color.Unspecified,
        background = emptyList()
    )
}
val LocalAppTypography = staticCompositionLocalOf {
    AppTypography()
}