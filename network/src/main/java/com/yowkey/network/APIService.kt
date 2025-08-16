package com.yowkey.network


import com.yowkey.network.BuildConfig.API_KEY
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @POST
    suspend fun getCurrentWeather(
        @Url url: String,
        @Query("key") key: String = API_KEY,
        @Query("q") q: String = "auto:ip"
    )
            : FetchCurrentWeatherResponse


}