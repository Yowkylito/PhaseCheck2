package com.yowkey.ui.components.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


enum class WeatherType {
    SUNNY,
    CLOUDY,
    RAINY,
    WINDY,
    THUNDERSTORM
}

// Define artistic gradient colors for different weather types
val sunnyGradientStart = Color(0xFFFFE082) // Light Apricot
val sunnyGradientEnd = Color(0xFFFFB74D) // Light Orange
val cloudyGradientStart = Color(0xFFB0BEC5) // Blue Grey 300
val cloudyGradientEnd = Color(0xFF78909C) // Blue Grey 500
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