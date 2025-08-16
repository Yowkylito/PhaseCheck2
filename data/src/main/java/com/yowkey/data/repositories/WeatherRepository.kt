package com.yowkey.data.repositories

import com.yowkey.network.FetchCurrentWeatherResponse


interface WeatherRepository {

    suspend fun getCurrentWeather(): FetchCurrentWeatherResponse

}