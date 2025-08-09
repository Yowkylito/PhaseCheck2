package com.yowkey.common.viewmodels

import androidx.lifecycle.ViewModel
import com.yowkey.common.intents.MainIntent
import com.yowkey.common.states.MainState
import com.yowkey.ui.components.theme.WeatherType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class MainViewModel() : ViewModel() {
    private val _mainState = MutableStateFlow<MainState>(MainState.Default)
    val mainState: StateFlow<MainState> = _mainState

    fun processIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.UpdateBackground -> updateBackground()
        }
    }

    private fun updateBackground() {
        val weatherTypes = WeatherType.entries.toTypedArray()
        val randomWeatherType = weatherTypes[Random.nextInt(weatherTypes.size)]
        _mainState.update { MainState.UpdateBackground(randomWeatherType) }
    }
}
