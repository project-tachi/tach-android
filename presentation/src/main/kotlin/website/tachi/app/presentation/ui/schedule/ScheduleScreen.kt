package website.tachi.app.presentation.ui.schedule

import android.util.Log
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.compose.CameraPositionState
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.Marker
import com.naver.maps.map.compose.MarkerState
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.PathOverlay
import com.naver.maps.map.compose.rememberCameraPositionState
import website.tachi.app.domain.model.Category
import website.tachi.app.domain.model.Schedule
import website.tachi.app.domain.model.TourismArea
import website.tachi.app.domain.model.getLatitude
import website.tachi.app.domain.model.getLongitude
import website.tachi.app.domain.model.getName
import website.tachi.app.presentation.R
import website.tachi.app.presentation.state.ScheduleUiState
import website.tachi.app.presentation.theme.AppTheme
import website.tachi.app.presentation.ui.nav.TachiDestination
import website.tachi.app.presentation.utils.toHHmmFormat
import java.util.Date


@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalNaverMapApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun ScheduleScreen(
    navController: NavController,
    viewModel: ScheduleViewModel = hiltViewModel(),
    preferenceId: String?,
    festivalId: String?,
    keywordId: String?,
    travelDuration: String,
    latitude: Double,
    longitude: Double
) {
    val uiState by viewModel.schedule.collectAsStateWithLifecycle(initialValue = ScheduleUiState.Loading)

    LaunchedEffect(Unit) {
        viewModel.loadSchedule(
            preferenceId,
            festivalId,
            keywordId,
            travelDuration,
            latitude,
            longitude
        )
    }

    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
    }

    when (val localUiState = uiState) {
        is ScheduleUiState.Loading -> {

        }

        is ScheduleUiState.Failure -> {

        }

        is ScheduleUiState.Success ->
            BottomSheetScaffold(
                sheetPeekHeight = 280.dp,
                sheetContainerColor = Color(0xfffafafa),
                sheetContent = {
                    Column {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            contentPadding = PaddingValues(0.dp, 8.dp)
                        ) {
                            item {
                                val pagerState = rememberPagerState(pageCount = {
                                    localUiState.scheduleRes.guides.size
                                })
                                HorizontalPager(
                                    state = pagerState,
                                    contentPadding = PaddingValues(28.dp, 0.dp),
                                ) { page ->
                                    localUiState.scheduleRes.guides.getOrNull(page)?.let {
                                        Box(modifier = Modifier.padding(4.dp, 0.dp)) {
                                            GuideCard(
                                                name = it.userData.name,
                                                content = it.introduction ?: "가이드 소개",
                                                imageUrl = it.userData.profilePicture
                                                    ?: "https://picsum.photos/200"
                                            ) {
                                                navController.navigate(TachiDestination.DESTINATION_GUIDE_DETAIL + "/" + it.id)
                                            }
                                        }
                                    }
                                }
                            }

                            items(localUiState.scheduleRes.scheduleResponses) {
                                Box(Modifier.padding(32.dp, 0.dp)) {
                                    SchedulePlaceCard(schedulePlace = it) {
                                        if (it.type == "Spot") {
                                            navController.navigate(TachiDestination.DESTINATION_SPOT_DETAIL + "/" + it.spotData?.id)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }) {

                localUiState.scheduleRes.scheduleResponses.getOrNull(0)?.let {
                    cameraPositionState.position = CameraPosition(
                        com.naver.maps.geometry.LatLng(
                            it.getLatitude(), it.getLongitude()
                        ), 13.0
                    )
                }

                NaverMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPositionState
                ) {
                    localUiState.scheduleRes.scheduleResponses.map {
                        Marker(
                            state = MarkerState(
                                position = com.naver.maps.geometry.LatLng(
                                    it.getLatitude(),
                                    it.getLongitude()
                                )
                            ),
                            captionText = it.getName()
                        )
                    }

                    PathOverlay(
                        coords = localUiState.scheduleRes.scheduleResponses.map {
                            com.naver.maps.geometry.LatLng(it.getLatitude(), it.getLongitude())
                        },
                        width = 2.dp,
                        outlineWidth = 0.dp,
                        color = Color.Red,
                        outlineColor = Color.White,
                        passedColor = Color.Gray,
                        passedOutlineColor = Color.White,
                    )
                }
            }
    }
}


@Preview
@Composable
fun SchedulePlaceCardPreview() {
}

@Composable
fun GuideCard(name: String, content: String, imageUrl: String, onClick: () -> Unit) {
    Column(
        Modifier
            .shadow(
                elevation = 20.dp,
                spotColor = Color(0x1A000000),
                ambientColor = Color(0x1A000000)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 10.dp))
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .clickable {
                onClick.invoke()
            }
            .padding(16.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                Modifier
                    .background(color = Color(0xFFFFD233), shape = RoundedCornerShape(size = 3.dp))
                    .padding(6.dp, 4.dp)
            ) {
                Text(
                    text = "지역 인증 완료",
                    style = AppTheme.typography.pretendardBody.copy(
                        fontSize = 9.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )
                )
            }

            Spacer(Modifier.width(6.dp))

            Box(
                Modifier
                    .background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(size = 3.dp))
                    .padding(6.dp, 4.dp)
            ) {
                Text(
                    text = "광고",
                    style = AppTheme.typography.pretendardBody.copy(
                        fontSize = 9.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )
                )
            }
        }

        Spacer(Modifier.height(10.dp))

        Text(
            modifier = Modifier.defaultMinSize(minHeight = 36.dp),
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
                model = imageUrl,
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

@Composable
fun SchedulePlaceCard(schedulePlace: Schedule, onClick: () -> Unit) {

    val name = schedulePlace.spotData?.name ?: schedulePlace.festival?.name ?: "name"
    val category = schedulePlace.spotData?.category?.name ?: "축제"
    val address = (if (schedulePlace.spotData?.roadAddress?.trim()
            ?.isBlank() == true
    ) schedulePlace.spotData?.address else schedulePlace.spotData?.roadAddress)
        ?: schedulePlace.festival?.address ?: "주소 오류"


    Row(
        Modifier
            .shadow(
                elevation = 20.dp,
                spotColor = Color(0x1A000000),
                ambientColor = Color(0x1A000000)
            )
            .clip(RoundedCornerShape(size = 10.dp))
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 10.dp))
            .clickable {
                onClick.invoke()
            }
            .padding(16.dp)
    ) {
        Column(
            Modifier.defaultMinSize(minWidth = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = category.split(",")[0],
                style = AppTheme.typography.pretendardBody.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W700,
                    color = Color(0xff000000),
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box(
                modifier = Modifier
                    .background(Color(0x13000000), RoundedCornerShape(16.dp))
                    .padding(6.dp, 4.dp)
            ) {
                Text(
                    text = schedulePlace.recommendedTime.toHHmmFormat(),
                    style = AppTheme.typography.pretendardBody.copy(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xCC000000),
                    )
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(Modifier.fillMaxWidth()) {
            Text(
                text = name,
                style = AppTheme.typography.pretendardBody.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xCC000000),
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.location_small),
                    contentDescription = null
                )

                Text(
                    text = address,
                    style = AppTheme.typography.pretendardBody.copy(
                        fontSize = 8.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xCC000000),
                    )
                )
            }
        }
    }
}