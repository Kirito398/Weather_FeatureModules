package ru.biozzlab.city_weather.data

import ru.biozzlab.city_weather.domain.models.City
import ru.biozzlab.city_weather.domain.type.Failure
import ru.biozzlab.entities.Either
import ru.biozzlab.entities.None

interface CityCache {
    fun loadCityData(cityName: String): Either<Failure, City>
    fun saveCityData(data: City): Either<Failure, None>
}