package com.weather.app.features.weatherdetails.view

import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.weather.app.common.ui.navigation.Screens
import com.weather.app.features.homeScreen.model.WeatherUIViewState
import com.weather.app.features.homeScreen.view.CustomDialog
import com.weather.app.features.homeScreen.viewModel.HomeViewModel
import com.weather.app.features.weatherdetails.viewModel.WeatherDetailViewModel
import kotlinx.coroutines.delay

@Composable
fun WeatherDetailsScreen(viewModel: WeatherDetailViewModel,
                         navController: NavController){
    var showDialog  = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        Log.e("Test","WeatherDetailsScreen - Launched Effct - Called()")
        viewModel.getWeatherData(13.083694,80.270186)
    }
    Log.e("Test","WeatherDetailsScreen - recomposed")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF65D6F3),  // Start color
                        Color(0xFF8F93DB)  // End color
                    ),
                    start = Offset(0f, 0f),  // Start point (top-left corner)
                    end = Offset(0f, 1000f)   // End point (bottom-left corner)
                )
            )
    ){
        Log.e("Test","WeatherDetailsScreen - Box - recomposed")
        when (viewModel.viewState.value) {
            WeatherUIViewState.IS_ERROR -> {
                Log.e("Test","WeatherDetailsScreen - ISERROR - Called()")
                showDialog.value = true
                if(viewModel.errorMessage.value.length>0) {
                    CustomDialog(
                        title = "Error",
                        content = "Something went wrong please try again later",
                        showDialog = showDialog.value,
                        onDismiss = { showDialog.value = false }
                    )
                }
            }
            WeatherUIViewState.LOADING -> {
                Log.e("Test","WeatherDetailsScreen - LOADING - Called()")
                val strokeWidth = 5.dp
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .drawBehind {
                            drawCircle(
                                Color.Red,
                                radius = size.width / 2 - strokeWidth.toPx() / 2,
                                style = Stroke(strokeWidth.toPx())
                            )
                        },
                    color = Color.LightGray,
                    strokeWidth = strokeWidth
                )
            }
            else -> {
                Log.e("Test","WeatherDetailsScreen - else - Called()")
                if(viewModel.weatherDetail!=null) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()

                    ) {
                        Row(
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp, top = 20.dp)
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(end = 8.dp)
                                    .weight(2f)
                                    .clip(RoundedCornerShape(13.dp, 13.dp, 13.dp, 13.dp))
                                    .background(Color(0x4dffffff))
                                    .padding(12.dp),
                            ) {
//               Row(
//                   verticalAlignment = Alignment.CenterVertically
//               ) {
//               }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "May 01,2024",
                                    modifier = Modifier,
                                    style = TextStyle(
                                        color = Color(0xAAFFFFFF),
                                        fontSize = 18.sp,
                                        fontFamily = FontFamily.Monospace,
                                        fontWeight = FontWeight.W500,
                                        fontStyle = FontStyle.Normal,
                                        //letterSpacing = 0.1.em,
                                        textDecoration = TextDecoration.None
                                    ),
                                    textAlign = TextAlign.Start
                                )
                                //Spacer(modifier = Modifier.height(10.dp))
                                Image(
                                    painter = painterResource(id = com.weather.app.common.ui.propellericons.R.drawable.w10d),
                                    contentDescription = "Weather Icon",
                                    modifier = Modifier
                                        .size(80.dp)
                                        .align(Alignment.CenterHorizontally),
                                )
                                //Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = "${viewModel.weatherDetail.value!!.weather[0].main}",
                                    modifier = Modifier,
                                    style = TextStyle(
                                        color = Color(0xAAFFFFFF),
                                        fontSize = 23.sp,
                                        fontFamily = FontFamily.Monospace,
                                        fontWeight = FontWeight.W700,
                                        fontStyle = FontStyle.Normal,
                                        //letterSpacing = 0.1.em,
                                        textDecoration = TextDecoration.None
                                    ),
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.height(15.dp))
                                Spacer(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Color(0xEFFFFFFF)))
                                Spacer(modifier = Modifier.height(15.dp))
                                Column {
                                    Text(
                                        text = "Wind Speed : ",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 19.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W500,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Start
                                    )
                                    Text(
                                        text = "${viewModel.weatherDetail.value!!.wind.speed} m/sec",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 21.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W600,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Column {
                                    Text(
                                        text = "Wind Direction : ",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 19.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W500,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Start
                                    )
                                    Text(
                                        text = "${viewModel.weatherDetail.value!!.wind.deg} dec",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 21.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W600,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Column {
                                    Text(
                                        text = "Gust : ",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 19.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W500,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Start
                                    )
                                    Text(
                                        text = "${viewModel.weatherDetail.value!!.wind.gust} m/sec",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 21.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W600,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Column {
                                    Text(
                                        text = "Humidity : ",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 19.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W500,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Start
                                    )
                                    Text(
                                        text = "${viewModel.weatherDetail.value!!.main.humidity}%",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 21.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W600,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Column {
                                    Text(
                                        text = "Pressure : ",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 19.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W500,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Start
                                    )
                                    Text(
                                        text = "${viewModel.weatherDetail.value!!.main.pressure} hPa",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 21.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W600,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Spacer(modifier = Modifier
                                    .padding(start = 35.dp, end = 35.dp)
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Color(0xEFFFFFFF)))
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                            Column(
                                modifier = Modifier
                                    .weight(2f)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(start = 8.dp)
                                        //.weight(2f)
                                        .clip(RoundedCornerShape(13.dp, 13.dp, 13.dp, 13.dp))
                                        .background(Color(0x4dffffff))
                                        .padding(10.dp)
                                ) {
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Column {
                                        Text(
                                            text = "Temperature : ",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 19.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W500,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Start
                                        )
                                        Text(
                                            text = "${viewModel.weatherDetail.value!!.main.temp} °C",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 21.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W600,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Column {
                                        Text(
                                            text = "Feels like : ",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 19.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W500,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Start
                                        )
                                        Text(
                                            text = "${viewModel.weatherDetail.value!!.main.feels_like} °C",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 21.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W600,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Spacer(modifier = Modifier
                                        .padding(start = 45.dp, end = 45.dp)
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color(0xEFFFFFFF)))
                                    Spacer(modifier = Modifier.height(10.dp))
                                }
                                Spacer(modifier = Modifier.height(20.dp))
                                Column(
                                    modifier = Modifier
                                        .padding(start = 8.dp)
                                        //.weight(2f)
                                        .clip(RoundedCornerShape(13.dp, 13.dp, 13.dp, 13.dp))
                                        .background(Color(0x4dffffff))
                                        .padding(10.dp)
                                ) {
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Column {
                                        Text(
                                            text = "Temp_min : ",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 19.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W500,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Start
                                        )
                                        Text(
                                            text = "${viewModel.weatherDetail.value!!.main.temp_min} °C",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 21.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W600,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Column {
                                        Text(
                                            text = "Temp_max : ",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 19.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W500,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Start
                                        )
                                        Text(
                                            text = "${viewModel.weatherDetail.value!!.main.temp_max} °C",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 21.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W600,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Column {
                                        Text(
                                            text = "Sunrise : ",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 19.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W500,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Start
                                        )
                                        Text(
                                            text = "0",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 21.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W600,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Column {
                                        Text(
                                            text = "Sunset : ",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 19.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W500,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Start
                                        )
                                        Text(
                                            text = "0",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 21.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W600,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Column {
                                        Text(
                                            text = "Cloudiness : ",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 19.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W500,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Start
                                        )
                                        Text(
                                            text = "${viewModel.weatherDetail.value!!.clouds.all}%",
                                            modifier = Modifier,
                                            style = TextStyle(
                                                color = Color(0xAAFFFFFF),
                                                fontSize = 21.sp,
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.W600,
                                                fontStyle = FontStyle.Normal,
                                                //letterSpacing = 0.1.em,
                                                textDecoration = TextDecoration.None
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Spacer(modifier = Modifier
                                        .padding(start = 45.dp, end = 45.dp)
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color(0xEFFFFFFF)))
                                    Spacer(modifier = Modifier.height(10.dp))
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Column(modifier = Modifier
                            .padding(start = 15.dp,end = 15.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(13.dp, 13.dp, 13.dp, 13.dp))
                            .background(Color(0x4dffffff))
                            .padding(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text(
                                        text = "Location : ",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 19.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W500,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Start
                                    )
                                    Text(
                                        text = "${viewModel.weatherDetail.value!!.name}",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 21.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W600,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Start
                                    )
                                }
                                Column {
                                    Text(
                                        text = "Sea Level :",
                                        modifier = Modifier.fillMaxWidth(),
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 19.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W500,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.End
                                    )
                                    Text(
                                        text = "${viewModel.weatherDetail.value!!.main.sea_level} hPa",
                                        modifier = Modifier.fillMaxWidth(),
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 21.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W600,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.End
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text(
                                        text = "Description : ",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 19.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W500,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Start
                                    )
                                    Text(
                                        text = "${viewModel.weatherDetail.value!!.weather[0].description}",
                                        modifier = Modifier,
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 21.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W600,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Start
                                    )
                                }
                                Column {
                                    Text(
                                        text = "Ground Level :",
                                        modifier = Modifier.fillMaxWidth(),
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 19.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W500,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.End
                                    )
                                    Text(
                                        text = "${viewModel.weatherDetail.value!!.main.grnd_level} hPa",
                                        modifier = Modifier.fillMaxWidth(),
                                        style = TextStyle(
                                            color = Color(0xAAFFFFFF),
                                            fontSize = 21.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W600,
                                            fontStyle = FontStyle.Normal,
                                            //letterSpacing = 0.1.em,
                                            textDecoration = TextDecoration.None
                                        ),
                                        textAlign = TextAlign.End
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }
        }
    }
}

//@Composable
//@Preview
//fun previewSplashScreen() {
//    WeatherDetailsScreen(navController = rememberNavController())
//}