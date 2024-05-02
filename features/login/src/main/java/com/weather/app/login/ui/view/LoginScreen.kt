package com.weather.app.login.ui.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.weather.app.common.ui.components.foundations.ButtonColorScheme
import com.weather.app.common.ui.components.foundations.ButtonEmphasis
import com.weather.app.common.ui.components.foundations.ButtonItems
import com.weather.app.common.ui.components.foundations.LoadDialogState
import com.weather.app.common.ui.widgets.WeatherModal
import com.weather.app.login.ui.R
import com.weather.app.login.ui.viewmodel.LoginViewModel

@Composable
fun LoginScreen( navController: NavHostController,
                 viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
    Log.e("Test","LoginScreen - viewModel - ${viewModel}")
    Box(
        contentAlignment = Alignment.TopCenter,
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
            modifier = Modifier.padding(top = 80.dp)
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Column(modifier = Modifier.align(alignment = Alignment.Center)) {
            LoginCardView(
                navController = navController,
                viewModel = viewModel
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_safe),
                    contentDescription = "safe",
                    modifier = Modifier.padding(top = 2.dp)
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    modifier = Modifier.padding(),
                    text = "Intrinsically Safe Device (Zone 1)",
                    color = Color.White
                )
            }
        }

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

        if (viewModel.loading.value) {
            LoadDialogState(
                text = "Login...",
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
                onDismissRequest = {
                    viewModel.loading.value = false
                }
            )
        }

        if (viewModel.showErrorPopup.value) {
            ExitModal(
                openDialog = viewModel.showErrorPopup,
                onOkayClick = {
                    viewModel.showErrorPopup.value = false
                }
            )
        }
    }
}
@Composable
fun ExitModal(
    openDialog: MutableState<Boolean>,
    title: String = "Login Failed",
    message: String = "Username or Password is incorrect, Please try logging in again.",
    onOkayClick: () -> Unit = {},
    buttonTwoText: String = "Okay"
) {
    if (openDialog.value) {
        WeatherModal(
            openDialog = openDialog,
            title = title,
            description = message,
            buttonList = listOf(
                ButtonItems(
                    emphasis = ButtonEmphasis.HIGH,
                    enabled = true,
                    buttonText = buttonTwoText,
                    colorScheme = ButtonColorScheme.NORMAL
                ) {
                    onOkayClick()
                }
            )
        )
    }
}
fun invalidInput(email: String, password: String) =
    email.isBlank() || password.isBlank()

@Composable
@Preview
fun previewSplashScreen() {
    LoginScreen(navController = rememberNavController())
}