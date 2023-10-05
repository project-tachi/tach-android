package website.tachi.app.presentation.ui.search

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
import website.tachi.app.presentation.ui.common.NumberPicker
import website.tachi.app.presentation.R
import website.tachi.app.presentation.theme.AppTheme
import website.tachi.app.presentation.ui.main.FestivalCard
import website.tachi.app.presentation.ui.main.StartButton
import website.tachi.app.presentation.ui.main.SubTitle
import website.tachi.app.presentation.ui.main.TravelStyleCompatCard


@Composable
@Preview
fun SearchScreenPreview() {
    AppTheme {
        SearchScreen()
    }
}

@Composable
fun SearchScreen() {
    var keyword by remember {
        mutableStateOf("")
    }

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

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Ready to Depart",
                    style = AppTheme.typography.gmarketSansBody.copy(
                        fontSize = 32.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xCCFFFFFF),
                    )
                )

                Spacer(modifier = Modifier.height(42.dp))

                Column(Modifier.fillMaxSize()) {
                    SubTitle(painter = painterResource(id = R.drawable.rocket_24), text = "Styles")

                    Spacer(Modifier.height(12.dp))

                    Row {
                        TravelStyleCompatCard(
                            painter = painterResource(id = R.drawable.north_star_24),
                            text = "Light"
                        )
                    }

                    Spacer(modifier = Modifier.height(48.dp))

                    SubTitle(
                        painter = painterResource(id = R.drawable.north_star_24),
                        text = "Festivals"
                    )

                    Spacer(Modifier.height(12.dp))

                    Row {
                        FestivalCard(
                            background = painterResource(id = R.drawable.drinkseoulpreview),
                            title = "드링크 서울",
                            eventTime = "13:00~21:00",
                            location = "COEX, Seoul"
                        )
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    SubTitle(
                        painter = painterResource(id = R.drawable.stopwatch_24),
                        text = "Period"
                    )

                    PeriodPicker()

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
                        items(10) {
                            KeywordItem(text = it.toString())
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    KeywordInput(value = keyword, onValueChangeRequest = { keyword = it })
                }
            }

            Box(modifier = Modifier.fillMaxWidth()) {
                StartButton(modifier = Modifier.align(Alignment.CenterEnd)) {

                }
            }
        }
    }
}


@Preview
@Composable
fun KeywordItemPreview() {
    AppTheme {
        KeywordItem(text = "Keyword")
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
fun KeywordItem(text: String) {
    Box(
        Modifier
            .background(color = Color(0x26FFFFFF), shape = RoundedCornerShape(size = 20.dp))
            .background(color = Color(0x1AFFFFFF), shape = RoundedCornerShape(size = 20.dp))
            .border(
                width = 0.5.dp,
                color = Color(0xCCFFFFFF),
                shape = RoundedCornerShape(size = 20.dp)
            )
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x29000000),
                ambientColor = Color(0x29000000)
            )
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
fun PeriodPicker() {
    var day by remember { mutableIntStateOf(0) }
    var hour by remember { mutableIntStateOf(0) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        NumberPicker(
            modifier = Modifier
                .defaultMinSize(minWidth = 100.dp),
            value = day,
            range = 0..10,
            onValueChange = {
                day = it
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
                hour = it
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