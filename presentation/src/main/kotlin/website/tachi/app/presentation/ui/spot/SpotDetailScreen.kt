package website.tachi.app.presentation.ui.spot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import website.tachi.app.domain.model.SchedulePlace
import website.tachi.app.presentation.R
import website.tachi.app.presentation.theme.AppTheme
import website.tachi.app.presentation.utils.toHHmmFormat

@Composable
fun SpotDetailScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp)) {
        Text(
            text = "Restaurant",
            style = AppTheme.typography.gmarketSansBody.copy(
                fontSize = 11.sp,
                fontWeight = FontWeight(500),
                color = Color(0x99000000),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "이름",
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000)
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.star_fill_24),
                modifier = Modifier.size(16.dp),
                contentDescription = null
            )

            Text(
                text = "0.0",
                style = AppTheme.typography.pretendardBody.copy(
                    fontSize = 11.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            )

            Spacer(Modifier.width(4.dp))

            Text(
                text = "(0개의 후기)",
                style = AppTheme.typography.pretendardBody.copy(
                    fontSize = 11.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0x99000000),
                )
            )
        }

        Spacer(Modifier.height(28.dp))

        Text(
            text = "소개",
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                color = Color(0xff000000),
            )
        )

        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "소개글",
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = Color(0x99000000),
            )
        )

        Spacer(Modifier.height(28.dp))

        Text(
            text = "후기",
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                color = Color(0xff000000),
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(10) {
                ReviewCard()
            }
        }
    }
}

@Composable
fun ReviewCard() {
    Column(
        Modifier
            .shadow(
                elevation = 20.dp,
                spotColor = Color(0x1A000000),
                ambientColor = Color(0x1A000000)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 10.dp))
            .padding(16.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.star_fill_24),
                modifier = Modifier.size(16.dp),
                contentDescription = null
            )

            Spacer(Modifier.width(4.dp))

            Text(
                text = "0.0",
                style = AppTheme.typography.pretendardBody.copy(
                    fontSize = 11.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            )
        }

        Spacer(Modifier.height(10.dp))

        Text(
            text = "리뷰글",
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 11.5.sp,
                fontWeight = FontWeight(400),
                color = Color(0xCC000000),
            )
        )

        Spacer(Modifier.height(10.dp))

        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                modifier = Modifier.size(24.dp).clip(CircleShape),
                model = "https://example.com/image.jpg",
                contentDescription = null,
            )

            Spacer(Modifier.width(8.dp))

            Text(
                text = "이름",
                style = AppTheme.typography.pretendardBody.copy(
                    fontSize = 11.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            )
        }
    }
}

@Preview
@Composable
fun SpotDetailScreenPreview() {
    SpotDetailScreen()
}