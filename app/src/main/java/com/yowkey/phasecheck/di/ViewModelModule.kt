package com.yowkey.phasecheck.di



import com.yowkey.common.viewmodels.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Single instance of MyRepository
    //single { MyRepository() }

    // ViewModel for MyViewModel
    // Koin will handle the ViewModel lifecycle
    viewModel { MainViewModel() }
  }