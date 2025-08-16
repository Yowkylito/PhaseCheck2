package com.yowkey.data.sources

import com.yowkey.network.FetchCurrentWeatherResponse

interface RemoteDataSource {
    suspend fun fetchCurrentWeather(): FetchCurrentWeatherResponse
}