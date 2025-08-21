package com.yowkey.data.models

import kotlinx.datetime.LocalTime

data class FutureWeather(
    val time: LocalTime = LocalTime(0, 0),
    val weatherType: WeatherType = WeatherType.WINDY,
)
