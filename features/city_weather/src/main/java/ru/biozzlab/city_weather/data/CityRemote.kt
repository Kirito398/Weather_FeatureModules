package ru.biozzlab.city_weather.data

import ru.biozzlab.features.city_weather_api.domain.models.City
import ru.biozzlab.features.city_weather_api.domain.type.Failure
import ru.biozzlab.entities.Either

interface CityRemote {
    fun loadCityData(cityName: String): Either<Failure, City>
}