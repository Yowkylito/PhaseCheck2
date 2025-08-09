package com.yowkey.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yowkey.common.states.MainState
import com.yowkey.common.viewmodels.MainViewModel
import com.yowkey.navigation.Route.Details
import com.yowkey.navigation.Route.Home
import com.yowkey.ui.components.screens.WeatherBaseLoadingScreen
import com.yowkey.ui.components.theme.WeatherType
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = koinViewModel()
) {
    val navController = rememberNavController()
    val state by mainViewModel.mainState.collectAsStateWithLifecycle()
    var themeColor by remember { mutableStateOf(WeatherType.SUNNY) }
    LaunchedEffect(state) {
        when (state) {
            MainState.Default -> {}
            is MainState.UpdateBackground -> {
                themeColor = (state as MainState.UpdateBackground).weatherType
            }
        }
    }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Home,
        enterTransition = { fadeIn(animationSpec = tween(0)) },
        exitTransition = { fadeOut(animationSpec = tween(0)) },
        popEnterTransition = { fadeIn(animationSpec = tween(0)) },
        popExitTransition = { fadeOut(animationSpec = tween(0)) }
    ) {
        composable<Home> {
            WeatherBaseLoadingScreen(
                weatherType = themeColor,
            ) { navController.navigate(Details("123")) }
        }
        composable<Details> {
            WeatherBaseLoadingScreen(
                weatherType = themeColor,
            ) { navController.navigate(Home) }
        }
    }
}