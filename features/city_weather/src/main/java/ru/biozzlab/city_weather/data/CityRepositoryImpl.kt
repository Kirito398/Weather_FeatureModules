package ru.biozzlab.city_weather.data

import ru.biozzlab.features.city_weather_api.domain.interfaces.CityRepository
import ru.biozzlab.features.city_weather_api.domain.models.City
import ru.biozzlab.features.city_weather_api.domain.type.Failure
import ru.biozzlab.entities.Either
import ru.biozzlab.entities.doNext
import ru.biozzlab.entities.flatMap

class CityRepositoryImpl(private val cache: CityCache, private val remote: CityRemote) : CityRepository {

    override fun getCity(): Either<Failure, City> {
        return cache.getDefaultCityName().flatMap { cityName ->
            when (val res = remote.loadCityData(cityName)) {
                is Either.Left -> cache.loadCityData(cityName)
                is Either.Right -> res.doNext { cache.saveCityData(it) }
            }
        }
    }
}