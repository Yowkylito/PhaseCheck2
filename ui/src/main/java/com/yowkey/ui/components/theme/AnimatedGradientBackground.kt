package com.yowkey.ui.components.theme

import com.yowkey.ui.components.screens.getWeatherBackgroundColors
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


/**
 * A composable function that provides an animated [Brush] based on the given [WeatherType].
 * The brush animates between color schemes when the [weatherType] changes.
 *
 * @param weatherType The current type of weather to determine the brush colors.
 * @param animationSpec The [AnimationSpec] to use for the color transition. Defaults to a 1-second tween.
 * @param defaultColors The list of colors to use if the [weatherType] doesn't match any known type
 *                      or if the color list for a type is empty. Defaults to transparent.
 * @return An animated [Brush] that transitions smoothly when [weatherType] changes.
 */
@Composable
fun rememberAnimatedWeatherBrush(
    weatherType: WeatherType,
    animationSpec: AnimationSpec<Color> = tween(durationMillis = 1000),
    defaultColors: List<Color> = listOf(Color.Transparent, Color.Transparent)
): Brush {
    val targetColors = getWeatherBackgroundColors(weatherType)

    val safeTargetColor1 = targetColors.getOrElse(0) { defaultColors.getOrElse(0) { Color.Transparent } }
    val safeTargetColor2 = targetColors.getOrElse(1) { defaultColors.getOrElse(1) { Color.Transparent } }

    val animatedColor1 by animateColorAsState(
        targetValue = safeTargetColor1,
        animationSpec = animationSpec,
        label = "weatherBrushColor1"
    )
    val animatedColor2 by animateColorAsState(
        targetValue = safeTargetColor2,
        animationSpec = animationSpec,
        label = "weatherBrushColor2"
    )

    return remember(animatedColor1, animatedColor2) {
        Brush.verticalGradient(colors = listOf(animatedColor1, animatedColor2))
    }
}

