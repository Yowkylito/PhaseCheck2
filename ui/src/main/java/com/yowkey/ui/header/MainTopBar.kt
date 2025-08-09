package com.yowkey.ui.header

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yowkey.ui.components.theme.WeatherType
import com.yowkey.ui.components.theme.getWeatherBackgroundColor


@Preview
@Composable
fun MainTopBar(
    modifier: Modifier = Modifier,
    backGroundColor: Brush = getWeatherBackgroundColor(WeatherType.SUNNY),
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(backGroundColor)
            .border(border = BorderStroke(1.dp, color = Black))
    )
    {

    }
}