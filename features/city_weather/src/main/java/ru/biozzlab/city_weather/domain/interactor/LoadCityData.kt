package ru.biozzlab.city_weather.domain.interactor

import ru.biozzlab.city_weather.domain.interfaces.CityRepository
import ru.biozzlab.city_weather.domain.models.City
import ru.biozzlab.city_weather.domain.type.Failure
import ru.biozzlab.entities.Either
import ru.biozzlab.entities.UseCase

class LoadCityData(private val repository: CityRepository) : UseCase<City, LoadCityData.Params, Failure>() {

    data class Params(val cityName: String)

    override suspend fun run(params: Params): Either<Failure, City> = repository.getCity(params.cityName)
}