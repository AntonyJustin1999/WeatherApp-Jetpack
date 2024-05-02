package com.weather.app.core.mappers

import com.weather.app.common.model.domain.Clouds
import com.weather.app.common.model.domain.Coordinates
import com.weather.app.common.model.domain.Coordination
import com.weather.app.common.model.domain.Main
import com.weather.app.common.model.domain.PlaceSearchModels
import com.weather.app.common.model.domain.Weather
import com.weather.app.common.model.domain.Wind
import com.weather.app.common.model.domain.util.DomainMapper
import com.weather.app.common.model.domain.util.DomainMapperWithList
import com.weather.app.data.remotesource.services.DTOs.Context
import com.weather.app.data.remotesource.services.DTOs.Country
import com.weather.app.data.remotesource.services.DTOs.Features
import com.weather.app.data.remotesource.services.DTOs.Properties
import com.weather.app.data.remotesource.services.DTOs.WeatherDetailsResponse

object PlacesSearchMappers : DomainMapperWithList<Features, PlaceSearchModels> {
    override fun toDomainList(initial: List<Features>): List<PlaceSearchModels> =
        initial.map {
            mapToDomainModel(it)
        }

    override fun fromDomainList(initial: List<PlaceSearchModels>): List<Features> =
        initial.map {
            mapFromDomainModel(it)
        }

    override fun mapToDomainModel(dto: Features): PlaceSearchModels = PlaceSearchModels(
        properties = com.weather.app.common.model.domain.Properties(
            coordinates = Coordinates(dto.properties.coordinates.latitude,dto.properties.coordinates.longitude),
            name = dto.properties.name,
            country = com.weather.app.common.model.domain.Country(dto.properties.context.country.name)
        ),
    )

    override fun mapFromDomainModel(model: PlaceSearchModels): Features = Features(
        properties = Properties(
            name = model.properties.name,
            context = Context(Country(model.properties.country.name)),
            coordinates = com.weather.app.data.remotesource.services.DTOs.Coordinates(
                model.properties.coordinates.latitude,
                model.properties.coordinates.longitude
            )
        )
    )
}

object WeatherDataMappers : DomainMapper<WeatherDetailsResponse, com.weather.app.common.model.domain.WeatherDetailsResponse> {
    override fun mapToDomainModel(model: WeatherDetailsResponse): com.weather.app.common.model.domain.WeatherDetailsResponse  =
        com.weather.app.common.model.domain.WeatherDetailsResponse(
            coord = Coordination(model.coord.lat,model.coord.lon),
            weather = model.weather.map {
                Weather(
                    id = it.id,
                    main = it.main,
                    description = it.description,
                    icon = it.icon
                )
            },
            main = Main(
                temp = model.main.temp,
                feels_like = model.main.feels_like,
                temp_min = model.main.temp_min,
                temp_max = model.main.temp_max,
                pressure = model.main.pressure,
                humidity = model.main.humidity,
                sea_level = model.main.sea_level,
                grnd_level = model.main.grnd_level
            ),
            wind = Wind(
                speed = model.wind.speed,
                deg = model.wind.deg,
                gust = model.wind.gust
            ),
            clouds = Clouds(all = model.clouds.all),
            name = model.name
        )

    override fun mapFromDomainModel(domainModel: com.weather.app.common.model.domain.WeatherDetailsResponse): WeatherDetailsResponse =
         WeatherDetailsResponse(
             coord = com.weather.app.data.remotesource.services.DTOs.Coordination(domainModel.coord.lat,domainModel.coord.lon),
             weather = domainModel.weather.map {
                 com.weather.app.data.remotesource.services.DTOs.Weather(
                     id = it.id,
                     main = it.main,
                     description = it.description,
                     icon = it.icon
                 )
             },
             main = com.weather.app.data.remotesource.services.DTOs.Main(
                 temp = domainModel.main.temp,
                 feels_like = domainModel.main.feels_like,
                 temp_min = domainModel.main.temp_min,
                 temp_max = domainModel.main.temp_max,
                 pressure = domainModel.main.pressure,
                 humidity = domainModel.main.humidity,
                 sea_level = domainModel.main.sea_level,
                 grnd_level = domainModel.main.grnd_level),
             wind = com.weather.app.data.remotesource.services.DTOs.Wind(
                 speed = domainModel.wind.speed,
                 deg = domainModel.wind.deg,
                 gust = domainModel.wind.gust
             ),
             clouds = com.weather.app.data.remotesource.services.DTOs.Clouds(all = domainModel.clouds.all),
             name = domainModel.name)

}