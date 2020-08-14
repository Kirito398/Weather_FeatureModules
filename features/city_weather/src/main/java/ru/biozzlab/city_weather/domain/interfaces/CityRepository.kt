package ru.biozzlab.city_weather.domain.interfaces

import ru.biozzlab.city_weather.domain.models.City
import ru.biozzlab.city_weather.domain.type.Failure
import ru.biozzlab.entities.Either

interface CityRepository {
    fun getCity(cityName: String): Either<Failure, City>
}