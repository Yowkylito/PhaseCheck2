package com.yowkey.common.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yowkey.common.intents.MainIntent
import com.yowkey.common.states.MainState
import com.yowkey.data.repositories.WeatherRepository
import com.yowkey.ui.components.theme.WeatherType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random


class MainViewModel(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _mainState = MutableStateFlow<MainState>(MainState.Default)
    val mainState: StateFlow<MainState> = _mainState

    suspend fun processIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.UpdateBackground -> getCurrentWeather()
        }
    }

    private fun getCurrentWeather() {
        viewModelScope.launch {
            val weatherTypes = WeatherType.entries.toTypedArray()
            val randomWeatherType = weatherTypes[Random.nextInt(weatherTypes.size)]
            _mainState.update { MainState.UpdateBackground(randomWeatherType) }

            val test = weatherRepository.getCurrentWeather(location = "")

            Log.d("test", test)
        }
    }
}
