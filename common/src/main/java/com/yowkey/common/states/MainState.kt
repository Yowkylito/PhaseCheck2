package com.yowkey.common.states

import com.yowkey.ui.components.theme.WeatherType

sealed class MainState {
    data object Default : MainState()
    data class UpdateBackground(val weatherType: WeatherType) : MainState()
}
