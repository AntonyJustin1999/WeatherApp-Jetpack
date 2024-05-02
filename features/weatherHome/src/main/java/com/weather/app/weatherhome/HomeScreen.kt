package com.weather.app.weatherhome

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen( navController: NavController){
    Text(text = "SplashScreen")
}

@Composable
@Preview
fun previewSplashScreen() {
    SplashScreen(navController = rememberNavController())
}