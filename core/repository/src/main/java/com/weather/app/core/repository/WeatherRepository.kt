package com.weather.app.core.repository
import com.weather.app.common.model.domain.PlaceSearchModels
import com.weather.app.data.remotesource.services.DTOs.WeatherDetailsResponse
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getPlaceSearch(searchWord:String): Flow<List<PlaceSearchModels>?>
    suspend fun getWeatherData(lat:Double,lon:Double): Flow<com.weather.app.common.model.domain.WeatherDetailsResponse?>
}