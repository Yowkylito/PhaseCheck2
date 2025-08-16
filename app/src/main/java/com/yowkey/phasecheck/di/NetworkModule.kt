package com.yowkey.phasecheck.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.yowkey.data.repositories.WeatherRepository
import com.yowkey.data.repositories.WeatherRepositoryImp
import com.yowkey.data.sources.RemoteDataSource
import com.yowkey.data.sources.RemoteDataSourceImp
import com.yowkey.network.ApiService
import com.yowkey.network.BASE_URL
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(androidContext()).build())
            .build()
    }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }


    single<WeatherRepository> { WeatherRepositoryImp(get()) }

    singleOf(::RemoteDataSourceImp) { bind<RemoteDataSource>() }
}