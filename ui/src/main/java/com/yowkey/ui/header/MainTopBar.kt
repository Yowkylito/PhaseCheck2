package com.yowkey.ui.header

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W800
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.yowkey.data.models.WeatherType
import com.yowkey.data.models.states.CurrentWeatherState
import com.yowkey.ui.R
import com.yowkey.ui.components.createImageLoader
import com.yowkey.ui.components.theme.getLoadingGifForWeatherType
import com.yowkey.ui.components.theme.getWeatherBackgroundColor


@Preview
@Composable
fun MainTopBar(
    modifier: Modifier = Modifier,
    weatherState: CurrentWeatherState = CurrentWeatherState(),
    weatherType: WeatherType = WeatherType.CLOUDY,
    backGroundColor: Brush = getWeatherBackgroundColor(WeatherType.SUNNY),
) {
    val context = LocalContext.current
    val imageLoader = remember { createImageLoader(context) }

    var gifLoading by remember { mutableIntStateOf(R.drawable.loading3) }

    LaunchedEffect(weatherType) {
        gifLoading = getLoadingGifForWeatherType(weatherType)
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(backGroundColor)
            .border(border = BorderStroke(1.dp, color = Black))
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    )
    {
        Image(
            modifier = Modifier.size(55.dp),
            painter = rememberAsyncImagePainter(gifLoading, imageLoader),
            contentDescription = null,

        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = weatherState.currentWeather,
                color = White,
                style = TextStyle(fontSize = 20.sp, fontWeight = W800)
            )
            Text(
                text = weatherState.lastUpdated,
                color = White,
                style = TextStyle(fontSize = 16.sp)
            )
        }
    }
}