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
    val body: TextStyle,
    val title: TextStyle
)

val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        content = Color.Unspecified,
        component = Color.Unspecified,
        background = emptyList()
    )
}
val LocalAppTypography = staticCompositionLocalOf {
    AppTypography(
        body = TextStyle.Default,
        title = TextStyle.Default
    )
}