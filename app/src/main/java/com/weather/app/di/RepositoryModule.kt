package com.weather.app.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
//    @Singleton
//    @Provides
//    fun provideWeatherRepository(
//        weatherAppService: WeatherAppService
//    ): WeatherRepository =
//        WeatherRepository_Impl(weatherAppService = weatherAppService)
}