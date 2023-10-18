package website.tachi.app.presentation.ui.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.w3c.dom.Text
import website.tachi.app.presentation.theme.AppTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun CurrentTime() {
    var currentTime by remember { mutableStateOf(getFormattedTime()) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1_000L)
            currentTime = getFormattedTime()
        }
    }

    Text(
        text = currentTime,
        style = AppTheme.typography.gmarketSansBody.copy(
            fontSize = 52.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFFFFFFFF),
        )
    )
}

fun getFormattedTime(): String {
    val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
    return formatter.format(Date())
}

@Preview
@Composable
fun PreviewCurrentTime() {
    CurrentTime()
}
