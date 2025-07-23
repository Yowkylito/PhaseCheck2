package com.yowkey.ui.components.screens

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.yowkey.ui.R

enum class WeatherType {
    SUNNY,
    CLOUDY,
    RAINY,
    WINDY,
    THUNDERSTORM
}

@Preview
@Composable
fun WeatherBaseLoadingScreen(weatherType: WeatherType = WeatherType.SUNNY) {
    val backGroundColor = when (weatherType) {
        WeatherType.SUNNY -> Yellow
        WeatherType.CLOUDY -> LightGray
        WeatherType.RAINY -> skyBlue
        WeatherType.WINDY -> gray
        WeatherType.THUNDERSTORM -> darkGray
    }
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    val gifLoading = when (weatherType) {
        WeatherType.SUNNY -> R.drawable.sunny_season
        WeatherType.CLOUDY -> R.drawable.rainy_season
        WeatherType.RAINY -> R.drawable.rainy_season
        WeatherType.WINDY -> R.drawable.rainy_season
        WeatherType.THUNDERSTORM -> R.drawable.storm
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(backGroundColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(gifLoading, imageLoader),
            contentDescription = null
        )
    }
}