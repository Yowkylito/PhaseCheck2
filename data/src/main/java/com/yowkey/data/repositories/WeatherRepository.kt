package com.yowkey.data.repositories
interface WeatherRepository {

    suspend fun getCurrentWeather(location: String): String

}