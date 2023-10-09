package website.tachi.app.presentation.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import website.tachi.app.domain.model.Festival
import website.tachi.app.domain.model.Keyword
import website.tachi.app.domain.model.Preference
import website.tachi.app.presentation.ui.common.NumberPicker
import website.tachi.app.presentation.R
import website.tachi.app.presentation.state.CurrentLocationUiState
import website.tachi.app.presentation.state.MainScreenUiState
import website.tachi.app.presentation.theme.AppTheme
import website.tachi.app.presentation.ui.main.FestivalCard
import website.tachi.app.presentation.ui.main.StartButton
import website.tachi.app.presentation.ui.main.SubTitle
import website.tachi.app.presentation.ui.main.TravelStyleCard
import website.tachi.app.presentation.ui.main.TravelStyleCompatCard
import website.tachi.app.presentation.utils.formatDateRange
import java.util.prefs.Preferences


@Composable
@Preview
fun SearchScreenPreview() {
    AppTheme {
        SearchScreen()
    }
}

@Composable
fun SearchScreen(
    navController: NavController = rememberNavController(),
    viewModel: SearchViewModel = hiltViewModel()
) {
    val uiState by viewModel.conditions.collectAsStateWithLifecycle(initialValue = MainScreenUiState.Loading)
    val location by viewModel.location.collectAsStateWithLifecycle(initialValue = CurrentLocationUiState.Loading)

    var day by remember { mutableIntStateOf(1) }
    var hour by remember { mutableIntStateOf(12) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.mainbackground),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

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
                Box(
                    Modifier
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

                Spacer(modifier = Modifier.height(42.dp))

                when (val localUiState = uiState) {
                    is MainScreenUiState.Loading -> {
                    }

                    is MainScreenUiState.Failure -> {

                    }

                    is MainScreenUiState.Success -> {
                        SearchConditionView(
                            festivals = localUiState.festivals,
                            keywords = localUiState.keywords,
                            preferences = localUiState.preferences,
                            onFestivalSelect = {
                                viewModel.selectFestivalId.value = it.id
                            },
                            onKeywordSelect = {
                                viewModel.selectKeywordId.value = it.id
                            },
                            onPreferenceSelect = {
                                viewModel.selectPreferenceId.value = it.id
                            },
                            selectedFestivalId = viewModel.selectFestivalId.value,
                            selectedKeywordId = viewModel.selectKeywordId.value,
                            selectedPreferenceId = viewModel.selectPreferenceId.value,
                            day = day,
                            hour = hour,
                            dayChange = {
                                day = it
                            },
                            hourChange = {
                                hour = it
                            }
                        )
                    }
                }
            }

            Box(modifier = Modifier.fillMaxWidth()) {
                val localLocation = location
                if (localLocation is CurrentLocationUiState.Success)
                    StartButton(modifier = Modifier.align(Alignment.CenterEnd)) {
                        val preferenceId: String? = viewModel.selectPreferenceId.value?.toString()
                        val festivalId: String? = viewModel.selectFestivalId.value?.toString()
                        val keywordId: String? = viewModel.selectKeywordId.value?.toString()
                        val travelDuration = day * 24 + hour
                        val latitude = localLocation.address.latitude
                        val longitude = localLocation.address.longitude

                        val route =
                            "schedule/${preferenceId ?: "unknown"}/${festivalId ?: "unknown"}/${keywordId ?: "unknown"}/$travelDuration/$latitude/$longitude"
                        navController.navigate(route)
                    }
            }
        }
    }
}

@Composable
fun SearchConditionView(
    festivals: List<Festival>,
    keywords: List<Keyword>,
    preferences: List<Preference>,
    onFestivalSelect: (Festival) -> Unit,
    onKeywordSelect: (Keyword) -> Unit,
    onPreferenceSelect: (Preference) -> Unit,
    selectedFestivalId: Long?,
    selectedKeywordId: Int?,
    selectedPreferenceId: Int?,
    day: Int, hour: Int, dayChange: (Int) -> Unit, hourChange: (Int) -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        SubTitle(painter = painterResource(id = R.drawable.rocket_24), text = "Styles")

        Spacer(Modifier.height(12.dp))

        LazyRow(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(preferences) {
                TravelStyleCompatCard(
                    imageUrl = "https://api.tachi.website/${it.iconPath}",
                    text = it.name,
                    isSelected = it.id == selectedPreferenceId
                ) {
                    onPreferenceSelect.invoke(it)
                }
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        SubTitle(
            painter = painterResource(id = R.drawable.north_star_24),
            text = "Festivals"
        )

        Spacer(Modifier.height(12.dp))

        LazyRow(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(festivals) {
                FestivalCard(
                    imageUrl = it.imageUrls.getOrNull(0) ?: "",
                    title = it.name,
                    eventTime = formatDateRange(it.startTime, it.endTime),
                    location = it.location,
                    isSelected = selectedFestivalId == it.id
                ) {
                    onFestivalSelect.invoke(it)
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        SubTitle(
            painter = painterResource(id = R.drawable.stopwatch_24),
            text = "Period"
        )

        PeriodPicker(day, hour, dayChange, hourChange)

        Spacer(modifier = Modifier.height(10.dp))

        SubTitle(
            painter = painterResource(id = R.drawable.lightbulb_24),
            text = "키워드 선택"
        )
        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(keywords) {
                KeywordItem(text = it.name, isSelected = it.id == selectedKeywordId) {
                    onKeywordSelect.invoke(it)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

//                    KeywordInput(value = keyword, onValueChangeRequest = { keyword = it })
    }
}


@Preview
@Composable
fun KeywordItemPreview() {
    AppTheme {
        KeywordItem(text = "Keyword", false) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun KeywordInputPreview() {
    KeywordInput(value = "", onValueChangeRequest = {

    })
}

@Composable
fun KeywordInput(value: String, onValueChangeRequest: (String) -> Unit) {
    Box(
        modifier = Modifier
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
            .fillMaxWidth()
            .background(color = Color(0x26FFFFFF), shape = RoundedCornerShape(size = 10.dp))
            .padding(12.dp)
    ) {
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = { text ->
                onValueChangeRequest.invoke(text)
            },
            textStyle = AppTheme.typography.pretendardBody.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color.White
            )
        ) {
            if (value.isBlank()) {
                Text(
                    text = "Input your own keyword", style =
                    AppTheme.typography.pretendardBody.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0x4DFFFFFF)
                    )
                )
            }
            it()
        }
    }
}

@Composable
fun KeywordItem(text: String, isSelected: Boolean, onSelect: () -> Unit) {
    Box(
        Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x29000000),
                ambientColor = Color(0x29000000)
            )
            .background(color = Color(0x26FFFFFF), shape = RoundedCornerShape(size = 20.dp))
            .background(color = Color(0x1AFFFFFF), shape = RoundedCornerShape(size = 20.dp))
            .let {
                if (isSelected) {
                    it.border(
                        width = 2.dp,
                        color = Color(0xCCFFFFFF),
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                } else {
                    it.border(
                        width = 0.5.dp,
                        color = Color(0x4DFFFFFF),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                }
            }

            .clickable {
                onSelect.invoke()
            }
            .padding(16.dp, 8.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = text,
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = Color.White
            )
        )
    }
}

@Composable
fun PeriodPicker(day: Int, hour: Int, dayChange: (Int) -> Unit, hourChange: (Int) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        NumberPicker(
            modifier = Modifier
                .defaultMinSize(minWidth = 100.dp),
            value = day,
            range = 0..3,
            onValueChange = {
                dayChange.invoke(it)
            },
            dividersColor = Color.Transparent,
            textStyle = AppTheme.typography.pretendardBody.copy(
                fontSize = 15.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
            )
        )

        Text(
            text = "일",
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
            )
        )


        Spacer(modifier = Modifier.width(24.dp))

        NumberPicker(
            modifier = Modifier
                .defaultMinSize(minWidth = 100.dp),
            value = hour,
            range = 0..23,
            onValueChange = {
                hourChange.invoke(it)
            },
            dividersColor = Color.Transparent,
            textStyle = AppTheme.typography.pretendardBody.copy(
                fontSize = 15.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
            )
        )

        Text(
            text = "시간",
            style = AppTheme.typography.pretendardBody.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
            )
        )

    }
}