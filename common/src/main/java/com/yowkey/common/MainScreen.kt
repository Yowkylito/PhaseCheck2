package com.yowkey.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yowkey.common.intents.MainIntent
import com.yowkey.common.states.MainState

import com.yowkey.common.viewmodels.MainViewModel
import com.yowkey.ui.components.theme.WeatherType
import com.yowkey.ui.components.theme.rememberAnimatedWeatherBrush
import com.yowkey.ui.header.MainTopBar
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = koinViewModel(),
    content: @Composable (modifier: Modifier) -> Unit = {},
) {

    val state by mainViewModel.mainState.collectAsStateWithLifecycle()
    var weatherType by remember { mutableStateOf(WeatherType.SUNNY) }
    LaunchedEffect(state) {
        when(state){
            MainState.Default -> {}
            is MainState.UpdateBackground ->{
               weatherType = (state as MainState.UpdateBackground).weatherType
            }
        }
    }
    LaunchedEffect(Unit) {
        while (true) {
            mainViewModel.processIntent(MainIntent.UpdateBackground)
            delay(2000)
        }
    }

    val animatedBackgroundBrush = rememberAnimatedWeatherBrush(weatherType = weatherType)
    Scaffold(
        containerColor = Color.Transparent,
        contentWindowInsets = WindowInsets.safeDrawing,
        topBar = {
            val padding = WindowInsets.systemBars.asPaddingValues()
            MainTopBar(
                modifier = Modifier.padding(top = padding.calculateTopPadding()),
                backGroundColor = animatedBackgroundBrush,
            )
        },
        content = { paddingValues ->
            content(modifier.padding(paddingValues))
        },
    )
}