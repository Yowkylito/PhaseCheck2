package com.yowkey.phasecheck.di



import com.yowkey.common.viewmodels.MainViewModel
import com.yowkey.data.repositories.WeatherRepository
import com.yowkey.data.repositories.WeatherRepositoryImp
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Single instance of MyRepository
    single<WeatherRepository> { WeatherRepositoryImp() }

    // Koin will handle the ViewModel lifecycle

    viewModel { MainViewModel(get()) }
  }