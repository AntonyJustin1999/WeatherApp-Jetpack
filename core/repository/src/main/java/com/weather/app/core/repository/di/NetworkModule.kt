package com.weather.app.core.repository.di

import com.weather.app.data.remotesource.services.PlaceSearchService
import com.weather.app.data.remotesource.services.WeatherDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providePlacesSearchService(@Named("Placesearch") retrofit: Retrofit): PlaceSearchService =
        retrofit.create(PlaceSearchService::class.java)

    @Singleton
    @Provides
    fun provideWeatherDetailService(@Named("WeatherDetail") retrofit: Retrofit): WeatherDataService =
        retrofit.create(WeatherDataService::class.java)
}