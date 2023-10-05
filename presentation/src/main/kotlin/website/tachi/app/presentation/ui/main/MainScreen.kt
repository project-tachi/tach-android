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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import website.tachi.app.presentation.R
import website.tachi.app.presentation.theme.AppTheme

@Preview
@Composable
fun MainScreenPreview() {
    AppTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
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
                CurrentLocationIndicator()

                Spacer(modifier = Modifier.height(100.dp))

                MainBanner()

                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                    SubTitle(painter = painterResource(id = R.drawable.rocket_24), text = "Styles")

                    Spacer(Modifier.height(12.dp))

                    Row {
                        TravelStyleCard(
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
                }
            }

            Box(modifier = Modifier.fillMaxWidth()) {
                StartButton(modifier = Modifier.align(Alignment.CenterEnd)) {

                }
            }
        }
    }
}

@Composable
fun TravelStyleCard(painter: Painter, text: String) {
    Column(
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
            .padding(16.dp)
    ) {

        Image(modifier = Modifier.size(16.dp), painter = painter, contentDescription = null)

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
fun TravelStyleCompatCard(painter: Painter, text: String) {
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
            .padding(16.dp, 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(modifier = Modifier.size(16.dp), painter = painter, contentDescription = null)

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
            background = painterResource(id = R.drawable.drinkseoulpreview),
            title = "드링크 서울",
            eventTime = "13:00~21:00",
            location = "COEX, Seoul"
        )
    }
}

@Composable
fun FestivalCard(background: Painter, title: String, eventTime: String, location: String) {
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
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = background,
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
        text = "Ready to Depart",
        style = AppTheme.typography.gmarketSansBody.copy(
            fontSize = 32.sp,
            fontWeight = FontWeight(700),
            color = Color(0xCCFFFFFF),
        )
    )

    Spacer(modifier = Modifier.height(12.dp))

    Text(
        text = "00:00",
        style = AppTheme.typography.gmarketSansBody.copy(
            fontSize = 52.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFFFFFFFF),
        )
    )

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
fun CurrentLocationIndicator() {
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
                text = "Jagok-ro, Gangnam-gu", style = AppTheme.typography.gmarketSansBody.copy(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                )
            )
        }

    }
}