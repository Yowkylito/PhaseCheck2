package com.yowkey.network

import kotlinx.serialization.Serializable


@Serializable
data class FetchCurrentWeatherResponse(
    val location: Location,
    val current: Current
)

@Serializable
data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double)

@Serializable
data class Current(
    val last_updated : String,
    val condition: Condition
)

@Serializable
data class Condition(
    val text: String,
    val icon: String,
    val code: Int,
)