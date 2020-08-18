package ru.biozzlab.city_weather.cache

import ru.biozzlab.city_weather.cache.entities.CityEntity
import ru.biozzlab.city_weather.domain.models.City

object ConverterUtils {
    fun convertEntityToModel(cityEntity: CityEntity): City {
        var city: City

        cityEntity.apply {
            city = City(
                cityName,
                weather,
                tempMinMax,
                icon,
                temp,
                pressure,
                humidity,
                description,
                windSpeed
            )
        }

        return city
    }

    fun convertModelToEntity(cityModel: City): CityEntity {
        var entity: CityEntity

        cityModel.apply {
            entity = CityEntity(
                cityName,
                weather,
                tempMinMax,
                icon,
                temp,
                pressure,
                humidity,
                description,
                windSpeed
            )
        }

        return entity
    }
}