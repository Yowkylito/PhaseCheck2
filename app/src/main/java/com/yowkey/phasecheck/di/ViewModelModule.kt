package com.yowkey.phasecheck.di


import org.koin.dsl.module

val appModule = module {
    // Single instance of MyRepository
    //single { MyRepository() }

    // ViewModel for MyViewModel
    // Koin will handle the ViewModel lifecycle
  }