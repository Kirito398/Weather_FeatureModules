package ru.biozzlab.features.city_weather_api.domain.interfaces

import ru.biozzlab.features.city_weather_api.domain.models.City
import ru.biozzlab.features.city_weather_api.domain.type.Failure
import ru.biozzlab.entities.Either

interface CityRepository {
    fun getCity(cityName: String): Either<Failure, City>
}