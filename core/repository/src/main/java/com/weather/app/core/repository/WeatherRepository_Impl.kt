package com.weather.app.core.repository

import android.util.Log
import com.weather.app.common.model.domain.PlaceSearchModels
import com.weather.app.core.mappers.PlacesSearchMappers
import com.weather.app.core.mappers.WeatherDataMappers
import com.weather.app.data.remotesource.services.PlaceSearchService
import com.weather.app.data.remotesource.services.WeatherDataService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepository_Impl @Inject constructor(
    private val placeSearchService: PlaceSearchService,
    private val weatherDataService: WeatherDataService
) : WeatherRepository {
    override suspend fun getPlaceSearch(searchWord: String): Flow<List<PlaceSearchModels>?> =
        flow {
            val response = placeSearchService.placesSearch(searchedWord = searchWord,
                proximity = "ip", access_token = "pk.eyJ1IjoiYW50b255anVzdGluMTIzIiwiYSI6ImNsaDJ5bTcyajFpNXYzbnBjM2pwcmFlbHIifQ.Jr4FsfekJqwurOnzo-83KA")
            emit(
                response.body()?.let {
                    Log.e("Test","WeatherRepository_Impl - PlacesSearchResponse = ${it}")
                    PlacesSearchMappers.toDomainList(it.features)
                } ?: run {
                    throw Exception("Exception ${this.toString()}")
                }
            )
        }

    override suspend fun getWeatherData(lat: Double, lon: Double): Flow<com.weather.app.common.model.domain.WeatherDetailsResponse?> =
        flow {
            val response = weatherDataService.getWeatherData(lat,lon,"metric","bb32f9d9f432110d92e963e50afbf680")
            emit(
                response.body()?.let {
                    Log.e("Test","WeatherRepository_Impl - GetWeatherDataResponse = ${it}")
                    WeatherDataMappers.mapToDomainModel(it)
                } ?: run {
                    throw Exception("Exception ${this.toString()}")
                }
            )
        }

}