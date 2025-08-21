package com.yowkey.data.sources

import com.yowkey.data.models.FutureWeather
import com.yowkey.data.models.WeatherType
import kotlinx.datetime.LocalTime

val MockWeatherData = listOf(
    FutureWeather(time = LocalTime(10, 0), weatherType = WeatherType.SUNNY),
    FutureWeather(time = LocalTime(11, 0), weatherType = WeatherType.CLOUDY),
    FutureWeather(time = LocalTime(12, 0), weatherType = WeatherType.CLOUDY),
    FutureWeather(time = LocalTime(13, 0), weatherType = WeatherType.RAINY),
    FutureWeather(time = LocalTime(14, 0), weatherType = WeatherType.RAINY),
    FutureWeather(time = LocalTime(15, 0), weatherType = WeatherType.SUNNY),
    FutureWeather(time = LocalTime(16, 0), weatherType = WeatherType.SUNNY),
    FutureWeather(time = LocalTime(17, 0), weatherType = WeatherType.CLOUDY),
    FutureWeather(time = LocalTime(18, 0), weatherType = WeatherType.CLOUDY),
    FutureWeather(time = LocalTime(19, 0), weatherType = WeatherType.RAINY),
    )
