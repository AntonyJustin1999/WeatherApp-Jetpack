package com.weather.app.data.remotesource.services

import com.weather.app.data.remotesource.services.DTOs.WeatherDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherDataService {
    @GET("/data/2.5/weather")
    suspend fun getWeatherData(
        @Query("lat") latitude:Double,
        @Query("lon") longitude:Double,
        @Query("units") units:String,
        @Query("APPID") APPID:String,
    ): Response<WeatherDetailsResponse>
}