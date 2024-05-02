package com.weather.app.features.homeScreen.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
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
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.weather.app.common.model.domain.Coordination
import com.weather.app.common.model.domain.PlaceSearchModels
import com.weather.app.common.model.domain.WeatherDetailsResponse
import com.weather.app.common.ui.navigation.Screens
import com.weather.app.features.homeScreen.model.WeatherUIViewState
import com.weather.app.features.homeScreen.viewModel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel,
               navController: NavHostController){
    var text by remember { mutableStateOf("") }
    var selected_index  = remember { mutableStateOf(0) }
    var showDialog  = remember { mutableStateOf(false) }

    Log.e("Test","HomeScreen recomposed")

    LaunchedEffect(Unit) {
        viewModel.weatherInputCities.add(Coordination(13.083694,80.270186))
        viewModel.weatherInputCities.add(Coordination(51.5073,-0.127647))
        viewModel.weatherInputCities.add(Coordination(19.07599,72.877393))
        viewModel.weatherInputCities.add(Coordination(40.7646511,-73.9525831))

        viewModel.getAllWeatherDetails(viewModel.weatherInputCities)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141436))
    ){
        when (viewModel.viewState.value) {
            WeatherUIViewState.IS_ERROR -> {
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
                //if(viewModel.weatherDetailsList.size < 4) {
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
                //}
            }
            else -> {

                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Pick location",
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 25.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.W800,
                            fontStyle = FontStyle.Normal,
                            //letterSpacing = 0.1.em,
                            textDecoration = TextDecoration.None
                        ),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Find the area or city that you want to know the detailed weather info " +
                                "at this time",
                        modifier = Modifier
                            .padding(start = 13.dp, end = 13.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 15.sp,
                            //fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.W300,
                            fontStyle = FontStyle.Normal,
                            letterSpacing = 0.1.em,
                            textDecoration = TextDecoration.None
                        ),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Row(modifier = Modifier.padding(start = 20.dp, end = 20.dp))
                    {
                        Row(
                            Modifier
                                .weight(2f)
                                .height(55.dp)
                                .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                                .background(Color(0xFF222149))
                                .padding(start = 15.dp, end = 15.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(id = com.weather.app.common.ui.propellericons.R.drawable.icon_search),
                                contentDescription = "Search Icon",
                                modifier = Modifier.size(20.dp)
                            )

                            TextField(
                                value = text,
                                onValueChange = { newText ->
                                    text = newText
                                    viewModel.getSearchedPlaces(newText)
                                },
                                placeholder = {
                                    Text(text = "Search",color = Color.White)
                                },
                                colors = TextFieldDefaults.textFieldColors(
                                    textColor = Color.White,
                                    disabledTextColor = Color.Transparent,
                                    backgroundColor = Color(0xFF222149),
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Transparent
                                ),
                                textStyle = TextStyle(
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.W300,
                                    fontStyle = FontStyle.Normal,
                                    letterSpacing = 0.1.em,
                                    textDecoration = TextDecoration.None
                                )
                            )
                        }
                        Spacer(modifier = Modifier.width(15.dp))
                        Box(
                            Modifier
                                .weight(0.5f)
                                .height(55.dp)
                                .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                                .background(Color(0xFF222149))
                        ) {
                            Image(
                                painter = painterResource(id = com.weather.app.common.ui.propellericons.R.drawable.ic_location),
                                contentDescription = "Search Icon",
                                modifier = Modifier
                                    .size(30.dp)
                                    .align(Alignment.Center)
                            )
                        }
                    }
                    if(viewModel.listOfSearchedPlaces.size > 0) {
                        //Spacer(modifier = Modifier.height(16.dp))
                        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
                            items(viewModel.listOfSearchedPlaces.size) { index ->
                                PlaceSearchUI(data = viewModel.listOfSearchedPlaces[index])
                            }
                        }
                    } else {
                        Spacer(modifier = Modifier.height(35.dp))
                        if(viewModel.weatherDetailsList.size > 0) {
                            LazyVerticalGrid(columns = GridCells.Fixed(2)
                            ) {
                                //item(span = { GridItemSpan(2) }) { TopInfo() }
                                items(viewModel.weatherDetailsList.size) {
                                    ShowWeatherCityUI(viewModel.weatherDetailsList[it],it,selected_index,navController,viewModel)
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
@Composable
fun CustomDialog(
    title:String,
    content:String,
    showDialog: Boolean,
    onDismiss: () -> Unit,
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = {
                Text(text = title)
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { onDismiss() }) {
                        Text(text = "Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { onDismiss() }) {
                        Text(text = "OK")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
            },
            text = {
                Text(text = content)
            }
        )
    }
}
@Composable
fun ShowWeatherCityUI(weatherDetail:WeatherDetailsResponse,
    index:Int,selected_index: MutableState<Int>,navController: NavHostController,viewModel: HomeViewModel){
    Log.e("Test","ShowWeatherCityUI recomposed")
    //var selected_index  by remember { mutableStateOf(0) }
    Column(modifier = Modifier
        .padding(
            start = if(index % 2 == 0) 20.dp else 10.dp,
            end = if(index % 2 == 0) 10.dp else 20.dp,
            top = if(index % 2 == 0) 20.dp else 0.dp,
            bottom = if(index % 2 == 0) 0.dp else 20.dp)
        .height(160.dp)
        .clip(RoundedCornerShape(17.dp, 17.dp, 17.dp, 17.dp))
        .clickable {
            selected_index.value = index
            navController.navigate("${Screens.WeatherDetailsScreen.route}")
            //navController.navigate("${Screens.WeatherDetailsScreen.route}/${viewModel.purchaseOrderItem.value?.itemId}")
        }
        .background(
            if (selected_index.value == index)
                Color(0xFF1B86E6)
            else
                Color(0xFF090A38)
        )) {
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Column(modifier = Modifier.padding(start = 15.dp, top = 15.dp)) {
                Text(
                    text = "${weatherDetail.main.temp}°C",
                    modifier = Modifier
                        .align(Alignment.Start),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 23.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.W700,
                        fontStyle = FontStyle.Normal,
                        //letterSpacing = 0.1.em,
                        textDecoration = TextDecoration.None
                    ),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = weatherDetail.weather[0].main,
                    modifier = Modifier
                        .align(Alignment.Start),
                    style = TextStyle(
                        color = Color(0xAAFFFFFF),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.W300,
                        fontStyle = FontStyle.Normal,
                        //letterSpacing = 0.1.em,
                        textDecoration = TextDecoration.None
                    ),
                    textAlign = TextAlign.Center
                )
            }
            Image(
                painter = painterResource(id = com.weather.app.common.ui.propellericons.R.drawable.w10d),
                contentDescription = "Weather Icon",
                modifier = Modifier.size(80.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = weatherDetail.name,
            modifier = Modifier
                .padding(start = 15.dp, bottom = 15.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W400,
                fontStyle = FontStyle.Normal,
                //letterSpacing = 0.1.em,
                textDecoration = TextDecoration.None
            ),
            textAlign = TextAlign.Start,
        )
    }
}
@Composable
fun PlaceSearchUI(data:PlaceSearchModels) {
    Row(modifier = Modifier
        .padding(start = 20.dp, end = 20.dp)
        .height(80.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = com.weather.app.common.ui.propellericons.R.drawable.ic_location),
            contentDescription = "Location Icon",
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(25.dp))
        Column {
            Text(
                text = data.properties.name,
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W400,
                    fontStyle = FontStyle.Normal,
                    //letterSpacing = 0.1.em,
                    textDecoration = TextDecoration.None
                ),
                textAlign = TextAlign.Start,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = data.properties.country.name,
                modifier = Modifier,
                style = TextStyle(
                    color = Color(0xAAFFFFFF),
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W300,
                    fontStyle = FontStyle.Normal,
                    //letterSpacing = 0.1.em,
                    textDecoration = TextDecoration.None
                ),
                textAlign = TextAlign.Start
            )
        }
    }
}

//@Composable
//@Preview(showBackground = true)
//fun previewSplashScreen() {
//    HomeScreen(navController = rememberNavController())
//}