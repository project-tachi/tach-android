package website.tachi.app.presentation.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import website.tachi.app.presentation.R
import website.tachi.app.presentation.state.CurrentLocationUiState
import website.tachi.app.presentation.state.MainBackgroundImageUrlUiState
import website.tachi.app.presentation.state.MainScreenUiState
import website.tachi.app.presentation.theme.AppTheme
import website.tachi.app.presentation.ui.common.CurrentTime
import website.tachi.app.presentation.ui.nav.TachiDestination
import website.tachi.app.presentation.ui.search.SearchViewModel
import website.tachi.app.presentation.utils.formatDateRange

@Preview
@Composable
fun MainScreenPreview() {
    AppTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen(
    navController: NavController = rememberNavController(),
    viewModel: SearchViewModel = hiltViewModel()
) {
    val mainBgImageUiState by viewModel.backgroundImageUrl.collectAsStateWithLifecycle(initialValue = MainBackgroundImageUrlUiState.Loading)

    val uiState by viewModel.conditions.collectAsStateWithLifecycle(initialValue = MainScreenUiState.Loading)
    val location by viewModel.location.collectAsStateWithLifecycle(initialValue = CurrentLocationUiState.Loading)

    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            when (val localUiState = mainBgImageUiState) {
                is MainBackgroundImageUrlUiState.Loading -> {
                }

                is MainBackgroundImageUrlUiState.Failure -> {

                }

                is MainBackgroundImageUrlUiState.Success -> {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(localUiState.url)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )

                    Spacer(
                        Modifier
                            .fillMaxSize()
                            .background(Color(0x73000000)))
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {

            Column(
                Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                val locationUiState = location
                if (locationUiState is CurrentLocationUiState.Success) {
                    CurrentLocationIndicator(text = locationUiState.address.address)
                }
                Spacer(modifier = Modifier.height(100.dp))

                MainBanner()

                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {

                    when (val localUiState = uiState) {
                        is MainScreenUiState.Loading -> {

                        }

                        is MainScreenUiState.Failure -> {

                        }

                        is MainScreenUiState.Success -> {
                            SubTitle(
                                painter = painterResource(id = R.drawable.rocket_24),
                                text = "Styles"
                            )

                            Spacer(Modifier.height(12.dp))

                            LazyRow(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(localUiState.preferences) {
                                    TravelStyleCard(
                                        imageUrl = "https://api.tachi.website/${it.iconPath}",
                                        text = it.name,
                                        viewModel.selectPreferenceId.value == it.id
                                    ) {
                                        viewModel.selectPreferenceId.value = it.id
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(48.dp))

                            SubTitle(
                                painter = painterResource(id = R.drawable.north_star_24),
                                text = "Festivals"
                            )

                            Spacer(Modifier.height(12.dp))

                            LazyRow(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(localUiState.festivals) {
                                    FestivalCard(
                                        imageUrl = it.imageUrls.getOrNull(0) ?: "",
                                        title = it.name,
                                        eventTime = formatDateRange(it.startTime, it.endTime),
                                        location = it.location,
                                        viewModel.selectFestivalId.value == it.id
                                    ) {
                                        viewModel.selectFestivalId.value = it.id
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Box(modifier = Modifier.fillMaxWidth()) {
                StartButton(modifier = Modifier.align(Alignment.CenterEnd)) {
                    navController.navigate(TachiDestination.DESTINATION_SEARCH)
                }
            }
        }
    }
}

@Composable
fun TravelStyleCard(imageUrl: String, text: String, isSelected: Boolean, onSelect: () -> Unit) {
    Column(
        Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x29000000),
                ambientColor = Color(0x29000000)
            )
            .defaultMinSize(minWidth = 140.dp)
            .background(color = Color(0x26FFFFFF), shape = RoundedCornerShape(size = 10.dp))
            .clickable {
                onSelect.invoke()
            }
            .let {
                if (isSelected) {
                    it.border(
                        width = 2.dp,
                        color = Color(0xCCFFFFFF),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                } else {
                    it.border(
                        width = 0.5.dp,
                        color = Color(0x4DFFFFFF),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                }
            }
            .padding(16.dp)
    ) {

        AsyncImage(
            modifier = Modifier.size(16.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = text,
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 15.sp,
                fontWeight = FontWeight(700),
                color = Color(0xE5FFFFFF),
            )
        )
    }
}

@Composable
fun TravelStyleCompatCard(
    imageUrl: String,
    text: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Row(
        Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x29000000),
                ambientColor = Color(0x29000000)
            )
            .border(
                width = 0.5.dp,
                color = Color(0x4DFFFFFF),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .defaultMinSize(minWidth = 140.dp)
            .background(color = Color(0x26FFFFFF), shape = RoundedCornerShape(size = 10.dp))
            .clickable {
                onSelect.invoke()
            }
            .let {
                if (isSelected) {
                    it.border(
                        width = 2.dp,
                        color = Color(0xCCFFFFFF),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                } else {
                    it.border(
                        width = 0.5.dp,
                        color = Color(0x4DFFFFFF),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                }
            }
            .padding(16.dp, 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier.size(16.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = text,
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 15.sp,
                fontWeight = FontWeight(700),
                color = Color(0xE5FFFFFF),
            )
        )
    }
}

@Composable
@Preview
fun FestivalCardPreview() {
    AppTheme {
        FestivalCard(
            imageUrl = "",
            title = "드링크 서울",
            eventTime = "13:00~21:00",
            location = "COEX, Seoul",
            true, {}
        )
    }
}

@Composable
fun FestivalCard(
    imageUrl: String,
    title: String,
    eventTime: String,
    location: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Box(
        Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x29000000),
                ambientColor = Color(0x29000000)
            )
            .clip(RoundedCornerShape(size = 10.dp))
            .width(140.dp)
            .height(110.dp)
            .clickable {
                onSelect.invoke()
            }
            .let {
                if (isSelected) {
                    it.border(
                        width = 2.dp,
                        color = Color(0xCCFFFFFF),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                } else {
                    it
                }
            }
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            Modifier
                .fillMaxSize()
                .background(Color(0x99000000))
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.width(9.dp),
                    painter = painterResource(id = R.drawable.location_24),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = location, style = AppTheme.typography.gmarketSansBody.copy(
                        fontSize = 8.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xCCFFFFFF),
                    )
                )
            }

            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            )

            Text(
                text = title,
                style = AppTheme.typography.pretendardBody.copy(
                    fontSize = 15.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xE5FFFFFF),
                )
            )

            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.clock_24),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = eventTime, style = AppTheme.typography.gmarketSansBody.copy(
                        fontSize = 6.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xCCFFFFFF),
                    )
                )
            }
        }
    }
}

@Composable
fun SubTitle(painter: Painter, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(modifier = Modifier.size(16.dp), painter = painter, contentDescription = null)
        Spacer(Modifier.width(8.dp))
        Text(
            text = text,
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 15.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
            )
        )
    }
}

@Composable
fun MainBanner() {
    Text(
        text = "I'M READY",
        style = AppTheme.typography.gmarketSansBody.copy(
            fontSize = 32.sp,
            fontWeight = FontWeight(700),
            color = Color(0xCCFFFFFF),
        )
    )

    Spacer(modifier = Modifier.height(12.dp))

    CurrentTime()
}

@Composable
fun StartButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Row(
        modifier = modifier
            .clickable {
                onClick.invoke()
            }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Start",
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF)
            )
        )

        Spacer(Modifier.width(8.dp))

        Image(painter = painterResource(id = R.drawable.arrow_right_24), contentDescription = null)
    }
}

@Composable
fun CurrentLocationIndicator(text: String) {
    Column {
        Text(
            text = "Current Location",
            style = AppTheme.typography.gmarketSansBody.copy(
                fontSize = 8.sp,
                fontWeight = FontWeight.Light,
                color = Color(0xFFFFFFFF),
            )
        )

        Spacer(Modifier.height(4.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.location_24),
                contentDescription = null
            )

            Spacer(Modifier.width(4.dp))


            Text(
                text = text, style = AppTheme.typography.gmarketSansBody.copy(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                )
            )
        }

    }
}