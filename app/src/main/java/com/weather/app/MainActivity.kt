package com.weather.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.weather.app.common.ui.navigation.Screens
import com.weather.app.common.ui.theme.WeatherAppTheme
import com.weather.app.features.homeScreen.view.HomeScreen
import com.weather.app.features.homeScreen.viewModel.HomeViewModel
import com.weather.app.features.weatherdetails.view.WeatherDetailsScreen
import com.weather.app.features.weatherdetails.viewModel.WeatherDetailViewModel
import com.weather.app.viewmodel.WeatherMainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val weatherMainViewModel = WeatherMainViewModel()

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme = remember { mutableStateOf(false) }
            WeatherAppTheme(
                isDarkTheme = isDarkTheme
            ) {
                Navigation(isDarkTheme = isDarkTheme,
                    shipMainViewModel = weatherMainViewModel)
            }
        }
    }

    @Composable
    @ExperimentalComposeUiApi
    fun Navigation(isDarkTheme: MutableState<Boolean>,
                   shipMainViewModel: WeatherMainViewModel,
    ) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screens.WeatherDetailsScreen.route
        ) {
            composable(Screens.HomeScreen.route) {
                val homeViewModel = hiltViewModel<HomeViewModel>()
                HomeScreen(homeViewModel,navController = navController)
            }
            composable(Screens.WeatherDetailsScreen.route) {
                val weathrDetailViewModel = hiltViewModel<WeatherDetailViewModel>()
                WeatherDetailsScreen(weathrDetailViewModel,navController = navController)
            }
        }
    }
}