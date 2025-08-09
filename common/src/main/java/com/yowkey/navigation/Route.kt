package com.yowkey.navigation
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data class Details(val itemId: String) : Route

}
