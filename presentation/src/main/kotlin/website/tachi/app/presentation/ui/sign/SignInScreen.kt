package website.tachi.app.presentation.ui.sign

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import website.tachi.app.presentation.R
import website.tachi.app.presentation.theme.AppTheme
import website.tachi.app.presentation.theme.KakaoYellow

@Preview
@Composable
fun SignInScreenPreview() {
    AppTheme {
        SignInScreen()
    }
}

@Composable
fun SignInScreen() {
    Column(Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .weight(1f))

        Column(
            Modifier
                .fillMaxWidth()
                .padding(32.dp)
        ) {
            Text(
                "Discover and Find Your Healing Place",
                style = AppTheme.typography.headline,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "At TAHCI, healing places for you are continuously being updated!",
                style = AppTheme.typography.subHeadline,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(48.dp))

            KakaoLoginButton()

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview
@Composable
fun KakaoLoginButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = KakaoYellow)
            .padding(24.dp)
            .shadow(
                elevation = 10.dp,
                spotColor = Color(0x1A000000),
                ambientColor = Color(0x1A000000)
            )
    ) {
        Image(
            modifier = Modifier.align(Alignment.CenterStart),
            painter = painterResource(id = R.drawable.kakaologo),
            contentDescription = null
        )
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Sign with Kakao", style =
            AppTheme.typography.body.copy(fontSize = 16.sp, fontWeight = FontWeight.Bold)
        )
    }
}