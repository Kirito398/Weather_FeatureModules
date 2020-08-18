package ru.biozzlab.city_weather.data

import ru.biozzlab.city_weather.domain.interfaces.CityRepository
import ru.biozzlab.city_weather.domain.models.City
import ru.biozzlab.city_weather.domain.type.Failure
import ru.biozzlab.entities.Either
import ru.biozzlab.entities.doNext

class CityRepositoryImpl(private val cache: CityCache, private val remote: CityRemote) : CityRepository {

    override fun getCity(cityName: String): Either<Failure, City> {
        return when (val res = remote.loadCityData(cityName)) {
            is Either.Left -> cache.loadCityData(cityName)
            is Either.Right -> res.doNext { cache.saveCityData(it) }
        }
    }
}