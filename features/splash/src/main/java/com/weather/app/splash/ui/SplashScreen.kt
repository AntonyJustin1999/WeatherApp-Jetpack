package com.weather.app.splash.ui

import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.weather.app.common.ui.navigation.Screens
import com.weather.app.splash.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen( navController: NavController){
    Log.e("Test","SplashScreen Called()")
    val scale = remember {
        Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.0f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = {
                    OvershootInterpolator(3f).getInterpolation(it)
                })
        )
        Log.e("Test","SplashScreen - LaunchedEffect - before delay")
        delay(800L)
        Log.e("Test","SplashScreen - LaunchedEffect - after delay")
        navController.popBackStack()
        navController.navigate(Screens.Login.route)
    }
    // Image
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF0D1C56),
                        Color(0xFF091848)
                    )
                )
            )
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_background_header_bar),
            contentDescription = "Logo",
            modifier = Modifier.align(alignment = Alignment.BottomCenter),
        )

        Image(
            painter = painterResource(id = R.drawable.splash_logo),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_mglnx),
                contentDescription = "Logo",
                modifier = Modifier.padding()
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(modifier = Modifier.padding(), text = "Version 2.0", color = Color.White)
        }
    }
}

@Composable
@Preview
fun previewSplashScreen() {
    SplashScreen(navController = rememberNavController())
}