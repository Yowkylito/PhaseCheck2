package com.yowkey.phasecheck

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.yowkey.common.MainScreen
import com.yowkey.common.viewmodels.MainViewModel
import com.yowkey.navigation.MainNavHost
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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



