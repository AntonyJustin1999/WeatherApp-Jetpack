package com.weather.app.data.remotesource.services

import com.weather.app.data.remotesource.services.DTOs.PlacesSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceSearchService {
    @GET("/search/geocode/v6/forward")
    suspend fun placesSearch(
        @Query("q") searchedWord:String,
        @Query("proximity") proximity:String,
        @Query("access_token") access_token:String,
    ): Response<PlacesSearchResponse>
}