package website.tachi.app.presentation.ui.guide

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import website.tachi.app.domain.model.Guide
import website.tachi.app.presentation.R
import website.tachi.app.presentation.state.GuideUiState
import website.tachi.app.presentation.state.MainScreenUiState
import website.tachi.app.presentation.theme.AppTheme
import website.tachi.app.presentation.ui.spot.ReviewCard

@Composable
fun GuideDetailScreen(
    navController: NavController = rememberNavController(),
    guideId: Long,
    viewModel: GuideDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.guide.collectAsStateWithLifecycle(initialValue = GuideUiState.Loading)

    LaunchedEffect(guideId) {
        viewModel.loadGuide(guideId)
    }

    when (val localUiState = uiState) {
        is GuideUiState.Loading -> {
        }

        is GuideUiState.Failure -> {

        }

        is GuideUiState.Success -> {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(32.dp)
            ) {
                Box(Modifier.fillMaxWidth()) {
                    Box(
                        Modifier
                            .align(Alignment.CenterStart)
                            .size(32.dp)
                            .clip(CircleShape)
                            .clickable {
                            }
                            .background(color = Color(0x3DFFFFFF))
                    ) {
                        Image(
                            modifier = Modifier.align(Alignment.Center),
                            painter = painterResource(id = R.drawable.chevron_left_24),
                            contentDescription = null
                        )
                    }
                }

                Spacer(Modifier.height(32.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .background(color = Color.LightGray),
                        model = "https://example.com/image.jpg",
                        contentDescription = null,
                    )

                    Spacer(modifier = Modifier.width(32.dp))

                    Column {
                        Text(
                            localUiState.guide.userData.name,
                            style = AppTheme.typography.pretendardBody.copy(
                                fontSize = 30.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF000000),
                            )
                        )
                        Text(
                            "지역 가이드", style = AppTheme.typography.pretendardBody.copy(
                                fontSize = 11.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0x99000000),
                            )
                        )
                    }

                }

                Spacer(Modifier.height(20.dp))

                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            modifier = Modifier.size(13.dp),
                            painter = painterResource(id = R.drawable.globe_24),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            localUiState.guide.tourismArea.name,
                            style = AppTheme.typography.pretendardBody.copy(
                                fontSize = 11.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0x99000000),
                            )
                        )
                    }

                    Spacer(Modifier.height(4.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            modifier = Modifier.size(13.dp),
                            painter = painterResource(id = R.drawable.edu),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            localUiState.guide.education ?: "학력 정보 없음",
                            style = AppTheme.typography.pretendardBody.copy(
                                fontSize = 11.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0x99000000),
                            )
                        )
                    }
                    Spacer(Modifier.height(4.dp))


                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            modifier = Modifier.size(13.dp),
                            painter = painterResource(id = R.drawable.note_24),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            localUiState.guide.languageProficiency ?: "어학 성적 정보 없음",
                            style = AppTheme.typography.pretendardBody.copy(
                                fontSize = 11.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0x99000000),
                            )
                        )
                    }
                    Spacer(Modifier.height(4.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            modifier = Modifier.size(13.dp),
                            painter = painterResource(id = R.drawable.clock_24),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            localUiState.guide.createdTime.toString(),
                            style = AppTheme.typography.pretendardBody.copy(
                                fontSize = 11.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0x99000000),
                            )
                        )
                    }
                }

                Spacer(Modifier.height(24.dp))

                Text(
                    text = localUiState.guide.introduction ?: "본인 소개 없음",
                    style = AppTheme.typography.pretendardBody.copy(
                        fontSize = 13.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xCC000000)
                    )
                )

                Spacer(Modifier.height(16.dp))

                Spacer(
                    Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = Color(0x14000000))
                )

                Spacer(Modifier.height(24.dp))

                Text(
                    text = "후기",
                    style = AppTheme.typography.pretendardBody.copy(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xff000000),
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

                    Spacer(Modifier.width(4.dp))


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
@Preview
fun GuideDetailScreenPreview() {
//    GuideDetailScreen()
}