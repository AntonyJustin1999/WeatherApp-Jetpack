package com.weather.app.common.model.domain

data class PlaceSearchModels(
    val properties:Properties,
)
data class Properties(
    val coordinates:Coordinates,
    val name:String,
    val country:Country,
)
data class Coordinates(
    val latitude:Double,
    val longitude:Double,
)
data class Country(
    val name:String,
)