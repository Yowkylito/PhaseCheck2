package com.yowkey.phasecheck

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.yowkey.common.MainScreen
import com.yowkey.common.states.MainState
import com.yowkey.common.viewmodels.MainViewModel
import com.yowkey.navigation.MainNavHost
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { mainViewModel.mainState.value == MainState.Loading }
        enableEdgeToEdge()
        setContent {
            MainScreen(
                mainViewModel = mainViewModel,
            ) { mainScreenPadding ->
                MainNavHost(
                    modifier = mainScreenPadding,
                    mainViewModel = mainViewModel
                )
            }
        }
    }
}



