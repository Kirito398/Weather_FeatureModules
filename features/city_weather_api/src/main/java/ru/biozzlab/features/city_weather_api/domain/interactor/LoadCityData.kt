package ru.biozzlab.features.city_weather_api.domain.interactor

import ru.biozzlab.features.city_weather_api.domain.interfaces.CityRepository
import ru.biozzlab.features.city_weather_api.domain.models.City
import ru.biozzlab.features.city_weather_api.domain.type.Failure
import ru.biozzlab.entities.Either
import ru.biozzlab.entities.None
import ru.biozzlab.entities.UseCase

class LoadCityData(private val repository: CityRepository) : UseCase<City, None, Failure>() {

    data class Params(val cityName: String)

    override suspend fun run(params: None): Either<Failure, City> = repository.getCity()
}