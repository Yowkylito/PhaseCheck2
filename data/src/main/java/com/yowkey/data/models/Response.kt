package com.yowkey.data.models

import kotlinx.serialization.Serializable
import java.io.Serial

@Serializable
data class FetchCurrentWeatherResponse(
    val mainWeatherInfo: String,
    val weather: String,
    val name: String
)