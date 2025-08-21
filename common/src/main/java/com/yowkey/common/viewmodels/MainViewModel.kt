package com.yowkey.common.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yowkey.common.intents.MainIntent
import com.yowkey.common.states.MainState
import com.yowkey.data.models.WeatherType
import com.yowkey.data.models.states.CurrentWeatherState
import com.yowkey.data.repositories.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _mainState = MutableStateFlow<MainState>(MainState.Default)
    val mainState: StateFlow<MainState> = _mainState

    private val _currentWeatherState = MutableStateFlow(CurrentWeatherState())
    val currentWeatherState: StateFlow<CurrentWeatherState> = _currentWeatherState
    fun processIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.UpdateBackground -> getCurrentWeather()
        }
    }

    private fun getCurrentWeather() {
        viewModelScope.launch {
            _mainState.update { MainState.Loading }
            try {
                val repositoryResponse = weatherRepository.getCurrentWeather()
                _currentWeatherState.update {
                    CurrentWeatherState(
                        lastUpdated = repositoryResponse.current.last_updated,
                        location = repositoryResponse.location.name,
                        region = repositoryResponse.location.region,
                        country = repositoryResponse.location.country,
                        currentWeather = repositoryResponse.current.condition.text
                    )
                }
                val determinedWeatherType =
                    mapCodeToWeatherType(repositoryResponse.current.condition.code)
                Log.d(
                    "MainViewModel23",
                    "Updating background. Determined WeatherType:$determinedWeatherType\n" +
                            "repositoryResponse: ${repositoryResponse}"
                )
                _mainState.update { MainState.UpdateBackground(determinedWeatherType) }
            } catch (e: Exception) {
                Log.e("MainViewModel23", "Exception in getCurrentWeather: ${e.message}")
                _mainState.update { MainState.Error("An unexpected error occurred") }
            }
        }
    }

    private fun isThunderstormCode(code: Int): Boolean {
        return when (code) {
            1087, // Thundery outbreaks possible
            1273, // Patchy light rain with thunder
            1276, // Moderate or heavy rain with thunder
            1279, // Patchy light snow with thunder
            1282  // Moderate or heavy snow with thunder
                -> true

            else -> false
        }
    }

    private fun mapCodeToWeatherType(code: Int): WeatherType {

        if (isThunderstormCode(code)) return WeatherType.THUNDERSTORM

        return when (code) {
            // SUNNY
            1000 -> WeatherType.SUNNY

            // CLOUDY
            1003, // Partly cloudy
            1006, // Cloudy
            1009, // Overcast
            1030, // Mist
            1135, // Fog
            1147  // Freezing fog
                -> WeatherType.CLOUDY

            // RAINY
            1063, // Patchy rain possible
            1150, // Patchy light drizzle
            1153, // Light drizzle
            1168, // Freezing drizzle
            1171, // Heavy freezing drizzle
            1180, // Patchy light rain
            1183, // Light rain
            1186, // Moderate rain at times
            1189, // Moderate rain
            1192, // Heavy rain at times
            1195, // Heavy rain
            1198, // Light freezing rain
            1201, // Moderate or heavy freezing rain
            1240, // Light rain shower
            1243, // Moderate or heavy rain shower
            1246  // Torrential rain shower
                -> WeatherType.RAINY

            // WINDY is handled by wind speed, not a primary code here.
            // Some codes might imply wind (e.g., blizzard), but they'd also be snow.

            else -> WeatherType.SUNNY
        }
    }
}
