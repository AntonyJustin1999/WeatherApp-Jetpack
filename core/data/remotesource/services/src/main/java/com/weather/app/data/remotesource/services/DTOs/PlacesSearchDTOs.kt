package com.weather.app.data.remotesource.services.DTOs

import com.google.gson.annotations.SerializedName

data class PlacesSearchRequest(
    @SerializedName("q")
    val searchedWord:String,
    @SerializedName("proximity")
    val proximity:String,
    @SerializedName("access_token")
    val access_token:String,
)

data class PlacesSearchResponse(
    @SerializedName("features")
    val features:List<Features>,
)

data class Features(
    @SerializedName("properties")
    val properties:Properties,
)
data class Properties(
    @SerializedName("coordinates")
    val coordinates:Coordinates,
    @SerializedName("name")
    val name:String,
    @SerializedName("context")
    val context:Context,
)

data class Coordinates(
    @SerializedName("latitude")
    val latitude:Double,
    @SerializedName("longitude")
    val longitude:Double,
)
data class Context(
    @SerializedName("country")
    val country:Country
)
data class Country(
    @SerializedName("name")
    val name:String,
)


