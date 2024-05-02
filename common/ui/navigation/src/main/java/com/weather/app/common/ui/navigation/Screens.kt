package com.weather.app.common.ui.navigation

sealed class Screens(val route: String) {
    object HomeScreen : Screens("homeScreen")
    object WeatherDetailsScreen : Screens("weatherDetailsScreen")
}