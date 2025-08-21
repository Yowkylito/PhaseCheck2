package com.yowkey.ui.components.theme

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.yowkey.data.models.WeatherType
import com.yowkey.ui.R


// Define artistic gradient colors for different weather types
val sunnyGradientStart = Color(0xFFFFE082) // Light Apricot
val sunnyGradientEnd = Color(0xFFFFB74D) // Light Orange
val cloudyGradientStart = Color(0xFFB0BEC5) // Blue Grey 300
val cloudyGradientEnd = Color(0xFF78909C) // Blue Grey 500

val cloudyComplementColorStart = Color(0xFFC5B7B0)
val rainyGradientStart = Color(0xFF64B5F6) // Light Blue
val rainyGradientEnd = Color(0xFF1976D2) // Dark Blue
val windyGradientStart = Color(0xFF90A4AE) // Blue Grey 400
val windyGradientEnd = Color(0xFF546E7A) // Blue Grey 700
val thunderstormGradientStart = Color(0xFF424242) // Grey 800
val thunderstormGradientEnd = Color(0xFF212121) // Grey 900

fun getWeatherBackgroundColor(weatherType: WeatherType): Brush {
    return when (weatherType) {
        WeatherType.SUNNY -> Brush.verticalGradient(
            colors = listOf(sunnyGradientStart, sunnyGradientEnd)
        )

        WeatherType.CLOUDY -> Brush.verticalGradient(
            colors = listOf(cloudyGradientStart, cloudyGradientEnd)
        )

        WeatherType.RAINY -> Brush.verticalGradient(
            colors = listOf(rainyGradientStart, rainyGradientEnd)
        )

        WeatherType.WINDY -> Brush.verticalGradient(
            colors = listOf(windyGradientStart, windyGradientEnd)
        )

        WeatherType.THUNDERSTORM -> Brush.verticalGradient(
            colors = listOf(thunderstormGradientStart, thunderstormGradientEnd)
        )
    }
}


fun getWeatherBackgroundColors(weatherType: WeatherType): List<Color> {
    return when (weatherType) {
        WeatherType.SUNNY -> listOf(sunnyGradientStart, sunnyGradientEnd)
        WeatherType.CLOUDY -> listOf(cloudyGradientStart, cloudyGradientEnd)
        WeatherType.RAINY -> listOf(rainyGradientStart, rainyGradientEnd)
        WeatherType.WINDY -> listOf(windyGradientStart, windyGradientEnd)
        WeatherType.THUNDERSTORM -> listOf(thunderstormGradientStart, thunderstormGradientEnd)
    }
}

/**
 * Returns the drawable resource ID for the loading GIF based on the WeatherType.
 *
 * @param weatherType The type of weather.
 * @return The resource ID of the corresponding GIF.
 */
@DrawableRes
fun getLoadingGifForWeatherType(weatherType: WeatherType?): Int {
    return when (weatherType) {
        WeatherType.SUNNY -> {
            val sunnyDrawables = listOf(
                R.drawable.sunny1,
                R.drawable.sunny2,
                R.drawable.sunny3,
                R.drawable.sunny4
            )
            sunnyDrawables.random()
        }

        WeatherType.CLOUDY -> {
            val cloudyDrawables = listOf(
                R.drawable.cloudy1,
                R.drawable.cloudy2,
                R.drawable.cloudy3,
                R.drawable.cloudy4
            )
            cloudyDrawables.random()
        }

        WeatherType.RAINY -> {
            val rainyDrawables = listOf(
                R.drawable.rainy1,
                R.drawable.rainy2,
                R.drawable.rainy3,
                R.drawable.rainy4
            )
            rainyDrawables.random()
        }

        WeatherType.WINDY -> {
            val windyDrawables = listOf(
                R.drawable.windy1,
                R.drawable.windy2,
                R.drawable.windy3,
                R.drawable.windy4
            )
            windyDrawables.random()
        }

        WeatherType.THUNDERSTORM -> R.drawable.storm
        null -> R.drawable.loading3
    }
}