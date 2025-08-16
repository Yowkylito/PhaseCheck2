package com.yowkey.phasecheck

import android.app.Application
import com.yowkey.phasecheck.di.networkModule
import com.yowkey.phasecheck.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                viewModelsModule,
                networkModule)

        }
    }
}