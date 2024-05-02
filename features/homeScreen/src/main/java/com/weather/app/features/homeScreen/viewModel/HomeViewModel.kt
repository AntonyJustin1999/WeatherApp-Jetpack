package com.weather.app.features.homeScreen.viewModel

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
class HomeViewModel @Inject constructor(
    private val weatherAppRepository: WeatherRepository,
):ViewModel() {
    val viewState = mutableStateOf(WeatherUIViewState.NONE)
    val listOfSearchedPlaces = mutableStateListOf<PlaceSearchModels>()
    val weatherDetailsList = mutableStateListOf<WeatherDetailsResponse>()
    val weatherInputCities = mutableListOf<Coordination>()
    val errorMessage = mutableStateOf("")

    fun getSearchedPlaces(searchedWord:String) {
        //viewState.value = WeatherUIViewState.LOADING
        viewModelScope.launch(Dispatchers.IO) {
            errorMessage.value = ""
            weatherAppRepository
                .getPlaceSearch(searchedWord)
                .distinctUntilChanged()
                .catch { error ->
                    run {
                        errorMessage.value = error.message.toString()
                        Log.e("Test","HomeViewModel - error - ${error.message}")
                        viewState.value = WeatherUIViewState.IS_ERROR
                    }
                }
                .collect { locationList ->
                    locationList.let {
                        listOfSearchedPlaces.clear()
                        it?.forEach{
                            listOfSearchedPlaces.add(it)
                        }
                        Log.e("Test","HomeViewModel - listOfSearchedPlaces = ${listOfSearchedPlaces}")
                        viewState.value = WeatherUIViewState.IS_SUCCESS
                    }
                }
        }
    }

    fun getAllWeatherDetails(coordinationList:List<Coordination>) {
        coordinationList.forEach {
            getWeatherData(it.lat,it.lon)
        }
    }

    fun getWeatherData(lat: Double, lon: Double) {
        viewState.value = WeatherUIViewState.LOADING
        viewModelScope.launch(Dispatchers.IO) {
            errorMessage.value = ""
            weatherAppRepository
                .getWeatherData(lat,lon)
                .distinctUntilChanged()
                .catch { error ->
                    run {
                        errorMessage.value = error.message.toString()
                        Log.e("Test","HomeViewModel - error - ${error.message}")
                        viewState.value = WeatherUIViewState.IS_ERROR
                    }
                }
                .collect { locationList ->
                    locationList.let {
                        weatherDetailsList.add(it!!)
                        Log.e("Test","HomeViewModel - WeatherDetailsResponse = $it")
                        viewState.value = WeatherUIViewState.IS_SUCCESS
                    }
                }
        }
    }
}