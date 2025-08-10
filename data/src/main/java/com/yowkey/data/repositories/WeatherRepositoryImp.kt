package com.yowkey.data.repositories

class WeatherRepositoryImp() : WeatherRepository {

    override suspend fun getCurrentWeather(location: String): String {
        return "WeatherRepositoryImp"
    }
}