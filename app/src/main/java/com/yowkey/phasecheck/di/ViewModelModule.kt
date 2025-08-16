package com.yowkey.phasecheck.di

import com.yowkey.common.viewmodels.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    // Koin will handle the ViewModel lifecycle
    viewModel { MainViewModel(get()) }
}