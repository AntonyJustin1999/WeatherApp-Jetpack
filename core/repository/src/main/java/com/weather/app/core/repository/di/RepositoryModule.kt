package com.weather.app.core.repository.di

import com.weather.app.core.repository.WeatherRepository
import com.weather.app.core.repository.WeatherRepository_Impl
import com.weather.app.data.remotesource.services.PlaceSearchService
import com.weather.app.data.remotesource.services.WeatherDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideWeatherRepository(
        placeSearchService: PlaceSearchService,
        weatherDataService: WeatherDataService
    ):WeatherRepository =
        WeatherRepository_Impl(
            placeSearchService = placeSearchService,
            weatherDataService = weatherDataService
        )
}