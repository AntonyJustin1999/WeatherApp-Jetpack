package com.weather.app.di

import com.google.gson.GsonBuilder
import com.weather.app.constants.NetworkConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private fun getHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//        val nwInterceptor=scnxDatastore?.let{ dataStore ->
//            val networkInterceptor = Interceptor { chain ->
//                val requestBuilder: Request.Builder = chain.request().newBuilder()
//                runBlocking {
//                    Log.d("Auth", "URL:: ${chain.request().url}")
//                    val isSyncAPICall = isSyncAPICalls(chain.request().url)
//                    val accessToken = if(isSyncAPICall){
//                        dataStore.read(ScnxDatastoreKeys.clientAccessToken).first()
//                    }else{
//                        dataStore.read(ScnxDatastoreKeys.accessToken).first()
//                    }
//                    val authorizationValue = "Bearer $accessToken"
//                    requestBuilder.header("Authorization",  authorizationValue)
//                    Log.d("Auth", "AuthorizationValue:: $authorizationValue")
//                }
//                chain.proceed(requestBuilder.build())
//            }
//            networkInterceptor
//        }


        var builder = OkHttpClient().newBuilder()
            .addInterceptor(logging)
            .connectTimeout(NetworkConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(NetworkConstants.READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(NetworkConstants.WRITE_TIMEOUT, TimeUnit.SECONDS)

//        nwInterceptor?.let{
//            builder = builder.addInterceptor(it)
//        }
        return builder.build()

    }

    @Singleton
    @Provides
    @Named("Placesearch")
    fun provideRetrofitPlaceSearch(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.mapbox.com")
            .client(getHttpClient())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

    @Singleton
    @Provides
    @Named("WeatherDetail")
    fun provideRetrofitWeatherDetail(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .client(getHttpClient())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

}