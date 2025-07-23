package com.yowkey.phasecheck

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.yowkey.ui.components.screens.WeatherBaseLoadingScreen

class MainActivity : AppCompatActivity(){
    //private val myViewModel: MyViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {

            WeatherBaseLoadingScreen()
        }
        //myViewModel.doSomething()
    }
}

