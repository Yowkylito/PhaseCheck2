package com.yowkey.data.repositories


import com.yowkey.data.sources.RemoteDataSource
import com.yowkey.network.FetchCurrentWeatherResponse

class WeatherRepositoryImp(
    private val remoteDataSource: RemoteDataSource
) : WeatherRepository {

    override suspend fun getCurrentWeather(): FetchCurrentWeatherResponse {
        val response = remoteDataSource.fetchCurrentWeather()
        return response

    }
}