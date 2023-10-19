package website.tachi.app.presentation.ui.spot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import website.tachi.app.presentation.R
import website.tachi.app.presentation.state.GuideUiState
import website.tachi.app.presentation.state.SpotUiState
import website.tachi.app.presentation.theme.AppTheme
import website.tachi.app.presentation.ui.guide.GuideDetailViewModel

@Composable
fun SpotDetailScreen(
    navController: NavController = rememberNavController(),
    spotId: Long,
    viewModel: SpotDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.spot.collectAsStateWithLifecycle(initialValue = SpotUiState.Loading)


    LaunchedEffect(spotId) {
        viewModel.loadSpot(spotId)
    }

    when (val localUiState = uiState) {
        is SpotUiState.Loading -> {
        }

        is SpotUiState.Failure -> {

        }

        is SpotUiState.Success -> {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(32.dp)
            ) {
                Text(
                    text = localUiState.spot.category.name,
                    style = AppTheme.typography.gmarketSansBody.copy(
                        fontSize = 11.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0x99000000),
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = localUiState.spot.name,
                    style = AppTheme.typography.pretendardBody.copy(
                        fontSize = 30.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000)
                    )
                )

                val averageRating =
                    localUiState.review.sumByDouble { it.rating } / localUiState.review.size
                val roundedAverage = Math.round(averageRating * 10.0) / 10.0

                Spacer(modifier = Modifier.height(10.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.star_fill_24),
                        modifier = Modifier.size(16.dp),
                        contentDescription = null
                    )

                    Text(
                        text = roundedAverage.toString(),
                        style = AppTheme.typography.pretendardBody.copy(
                            fontSize = 11.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )
                    )

                    Spacer(Modifier.width(4.dp))

                    Text(
                        text = "(${localUiState.review.size}개의 후기)",
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
                    text = localUiState.spot.content,
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
                    items(localUiState.review) {
                        ReviewCard(
                            roundedAverage,
                            it.content,
                            it.user.name,
                            "https://picsum.photos/200"
                        )
                    }
                }
            }
        }

    }
}

@Composable
fun ReviewCard(rating: Double, content: String, name: String, profileImageUrl: String) {
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
                text = rating.toString(),
                style = AppTheme.typography.pretendardBody.copy(
                    fontSize = 11.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            )
        }

        Spacer(Modifier.height(10.dp))

        Text(
            text = content,
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 11.5.sp,
                fontWeight = FontWeight(400),
                color = Color(0xCC000000),
            )
        )

        Spacer(Modifier.height(10.dp))

        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape),
                model = profileImageUrl,
                contentDescription = null,
            )

            Spacer(Modifier.width(8.dp))

            Text(
                text = name,
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
//    SpotDetailScreen()
}