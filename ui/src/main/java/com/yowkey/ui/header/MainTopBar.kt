package com.yowkey.ui.header

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W800
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yowkey.data.models.states.CurrentWeatherState
import com.yowkey.ui.components.theme.WeatherType
import com.yowkey.ui.components.theme.getWeatherBackgroundColor


@Preview
@Composable
fun MainTopBar(
    modifier: Modifier = Modifier,
    weatherState: CurrentWeatherState = CurrentWeatherState(),
    backGroundColor: Brush = getWeatherBackgroundColor(WeatherType.SUNNY),
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(backGroundColor)
            .border(border = BorderStroke(1.dp, color = Black))
            .padding(start = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    )
    {
        Text(
            text = weatherState.currentWeather,
            color = White,
            style = TextStyle(
                fontSize=20.sp,
                fontWeight = W800
            )
        )
        Text(
            text = weatherState.lastUpdated,
            color = White
        )
    }
}