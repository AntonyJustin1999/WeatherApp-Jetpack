package com.weather.app.features.weatherdetails.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.app.common.model.domain.Coordination
import com.weather.app.common.model.domain.PlaceSearchModels
import com.weather.app.common.model.domain.WeatherDetailsResponse
import com.weather.app.core.repository.WeatherRepository
import com.weather.app.features.homeScreen.model.WeatherUIViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherDetailViewModel @Inject constructor(
    private val weatherAppRepository: WeatherRepository,
):ViewModel() {
    val viewState = mutableStateOf(WeatherUIViewState.NONE)
    var weatherDetail = mutableStateOf<WeatherDetailsResponse?>(null)
    val errorMessage = mutableStateOf("")

    fun getWeatherData(lat: Double, lon: Double) {
        Log.e("Test","WeatherDetailViwModl - ")
        viewState.value = WeatherUIViewState.LOADING
        viewModelScope.launch(Dispatchers.IO) {
            errorMessage.value = ""
            weatherAppRepository
                .getWeatherData(lat,lon)
                .distinctUntilChanged()
                .catch { error ->
                    run {
                        errorMessage.value = error.message.toString()
                        Log.e("Test","WeatherDetailViewModel - error - ${error.message}")
                        viewState.value = WeatherUIViewState.IS_ERROR
                    }
                }
                .collect { locationList ->
                    locationList.let {
                        weatherDetail.value = it
                        Log.e("Test","WeatherDetailViewModel - WeatherDetailsResponse = $it")
                        viewState.value = WeatherUIViewState.IS_SUCCESS
                    }
                }
        }
    }
}