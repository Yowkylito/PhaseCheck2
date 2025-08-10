package com.yowkey.network



import com.yowkey.data.models.FetchCurrentWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") location: String,
        @Query("key") apiKey: String,
    ): Response<FetchCurrentWeatherResponse>


}