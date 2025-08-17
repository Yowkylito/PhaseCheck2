package com.yowkey.ui.components.screens

import android.annotation.SuppressLint
import android.os.Build.VERSION.SDK_INT
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import androidx.compose.ui.graphics.Color.Companion.White
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.yowkey.data.models.states.CurrentWeatherState
import com.yowkey.ui.R
import com.yowkey.ui.components.theme.WeatherType
import com.yowkey.ui.components.theme.cloudyGradientEnd
import com.yowkey.ui.components.theme.cloudyGradientStart
import com.yowkey.ui.components.theme.rainyGradientEnd
import com.yowkey.ui.components.theme.rainyGradientStart
import com.yowkey.ui.components.theme.rememberAnimatedWeatherBrush
import com.yowkey.ui.components.theme.sunnyGradientEnd
import com.yowkey.ui.components.theme.sunnyGradientStart
import com.yowkey.ui.components.theme.thunderstormGradientEnd
import com.yowkey.ui.components.theme.thunderstormGradientStart
import com.yowkey.ui.components.theme.windyGradientEnd
import com.yowkey.ui.components.theme.windyGradientStart


fun getWeatherBackgroundColors(weatherType: WeatherType): List<Color> {
    return when (weatherType) {
        WeatherType.SUNNY -> listOf(sunnyGradientStart, sunnyGradientEnd)
        WeatherType.CLOUDY -> listOf(cloudyGradientStart, cloudyGradientEnd)
        WeatherType.RAINY -> listOf(rainyGradientStart, rainyGradientEnd)
        WeatherType.WINDY -> listOf(windyGradientStart, windyGradientEnd)
        WeatherType.THUNDERSTORM -> listOf(thunderstormGradientStart, thunderstormGradientEnd)
    }
}


@SuppressLint("UnrememberedMutableInteractionSource")
@Preview
@Composable
fun WeatherBaseLoadingScreen(
    modifier: Modifier = Modifier,
    weatherType: WeatherType = WeatherType.CLOUDY,
    currentWeatherState: CurrentWeatherState = CurrentWeatherState(),
    onClick: () -> Unit = {}
) {


    val animatedBackgroundBrush = rememberAnimatedWeatherBrush(weatherType = weatherType)
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

    Column(
        modifier=modifier
            .fillMaxSize()
            .background(brush = animatedBackgroundBrush)
            .animateContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = onClick
                ),
            painter = rememberAsyncImagePainter(gifLoading, imageLoader),
            contentDescription = null
        )

        Text(
            text = currentWeatherState.location,
            color = White
        )
        Text(
            text = currentWeatherState.region,
            color = White
        )
        Text(
            text = currentWeatherState.country,
            color = White
        )
    }

}
