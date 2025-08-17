package com.yowkey.data.models.states

data class CurrentWeatherState(
    val lastUpdated: String = "",
    val location: String = "",
    val region: String = "",
    val country: String = "",
    val currentWeather: String = "",

)
