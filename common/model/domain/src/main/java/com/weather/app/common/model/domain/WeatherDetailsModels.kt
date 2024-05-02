package com.weather.app.common.model.domain

data class WeatherDetailsResponse(
    val coord:Coordination,
    val weather:List<Weather>,
    val main:Main,
    val wind:Wind,
    val clouds:Clouds,
    val name:String,
)
data class Coordination(
    val lat:Double,
    val lon:Double,
)

data class Weather(
    val id:Int,
    val main:String,
    val description:String,
    val icon:String,
)
data class Main(
    val temp:Float,
    val feels_like:Float,
    val temp_min:Float,
    val temp_max:Float,
    val pressure:Float,
    val humidity:Float,
    val sea_level:Float,
    val grnd_level:Float,
)
data class Wind(
    val speed:Float,
    val deg:Float,
    val gust:Float,
)
data class Clouds(
    val all:Int,
)