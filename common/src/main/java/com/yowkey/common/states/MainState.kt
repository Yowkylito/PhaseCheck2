package com.yowkey.common.states

import com.yowkey.data.models.WeatherType

sealed class MainState {
    data object Default : MainState()
    data object Loading : MainState()
    data class Error(val message: String) : MainState()
    data class UpdateBackground(val weatherType: WeatherType) : MainState()
}
