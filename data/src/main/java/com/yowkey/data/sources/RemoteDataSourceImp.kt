package com.yowkey.data.sources

import android.util.Log
import com.yowkey.network.API
import com.yowkey.network.ApiService
import com.yowkey.network.BASE_URL

import com.yowkey.network.FetchCurrentWeatherResponse

class RemoteDataSourceImp(
    private val apiService: ApiService
) : RemoteDataSource {
    override suspend fun fetchCurrentWeather(): FetchCurrentWeatherResponse {
        val url = "${BASE_URL}/${API.FETCH_CURRENT_WEATHER.url}"
        Log.d("RemoteDataSourceImp", "fetchCurrentWeather: $url")
        val response = apiService.getCurrentWeather(url)
        return response

    }
}