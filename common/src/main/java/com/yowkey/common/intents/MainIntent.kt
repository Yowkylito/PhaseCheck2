package com.yowkey.common.intents

sealed class MainIntent {
    data object UpdateBackground : MainIntent()
}
