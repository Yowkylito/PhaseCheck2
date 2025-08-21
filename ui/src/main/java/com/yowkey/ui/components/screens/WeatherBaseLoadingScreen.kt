package com.yowkey.ui.components.screens

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.yowkey.data.models.WeatherType
import com.yowkey.data.models.states.CurrentWeatherState
import com.yowkey.data.sources.MockWeatherData
import com.yowkey.ui.R
import com.yowkey.ui.components.WeatherContainer
import com.yowkey.ui.components.createImageLoader
import com.yowkey.ui.components.theme.getLoadingGifForWeatherType
import com.yowkey.ui.components.theme.rememberAnimatedWeatherBrush


@SuppressLint("UnrememberedMutableInteractionSource")
@Preview
@Composable
fun WeatherBaseLoadingScreen(
    modifier: Modifier = Modifier,
    weatherType: WeatherType = WeatherType.CLOUDY,
    currentWeatherState: CurrentWeatherState = CurrentWeatherState(),
) {
    val animatedBackgroundBrush = rememberAnimatedWeatherBrush(weatherType = weatherType)
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = animatedBackgroundBrush)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp)
                .animateContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(MockWeatherData) { weather ->
                        WeatherContainer(
                            weatherType = weather.weatherType,
                            time = weather.time
                        )
                    }
                }
            }

            item {
                Box(modifier = Modifier.fillMaxWidth()
                    .height(200.dp)) {
                MapScreen()
                }
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 16.dp, bottom = 16.dp, end = 16.dp)       )
        {
            Text(
                text = currentWeatherState.location,
                color = White,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = currentWeatherState.region,
                color = White,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = currentWeatherState.country,
                color = White
            )
        }
    }

}
@Composable
fun MapScreen() {
    val atasehir = LatLng(40.9971, 29.1007)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(atasehir, 15f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    )
}
