package com.weather.app.data.remotesource.services.DTOs

import com.google.gson.annotations.SerializedName

data class WeatherDetailsResponse(
    @SerializedName("coord")
    val coord:Coordination,
    @SerializedName("weather")
    val weather:List<Weather>,
    @SerializedName("main")
    val main:Main,
    @SerializedName("wind")
    val wind:Wind,
    @SerializedName("clouds")
    val clouds:Clouds,
    @SerializedName("name")
    val name:String,
)
data class Coordination(
    @SerializedName("lat")
    val lat:Double,
    @SerializedName("lon")
    val lon:Double,
)

data class Weather(
    @SerializedName("id")
    val id:Int,
    @SerializedName("main")
    val main:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("icon")
    val icon:String,
)
data class Main(
    @SerializedName("temp")
    val temp:Float,
    @SerializedName("feels_like")
    val feels_like:Float,
    @SerializedName("temp_min")
    val temp_min:Float,
    @SerializedName("temp_max")
    val temp_max:Float,
    @SerializedName("pressure")
    val pressure:Float,
    @SerializedName("humidity")
    val humidity:Float,
    @SerializedName("sea_level")
    val sea_level:Float,
    @SerializedName("grnd_level")
    val grnd_level:Float,
)
data class Wind(
    @SerializedName("speed")
    val speed:Float,
    @SerializedName("deg")
    val deg:Float,
    @SerializedName("gust")
    val gust:Float,
)
data class Clouds(
    @SerializedName("all")
    val all:Int,
)