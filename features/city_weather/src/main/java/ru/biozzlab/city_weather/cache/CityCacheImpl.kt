package ru.biozzlab.city_weather.cache

import ru.biozzlab.city_weather.cache.ConverterUtils.convertEntityToModel
import ru.biozzlab.city_weather.cache.ConverterUtils.convertModelToEntity
import ru.biozzlab.city_weather.data.CityCache
import ru.biozzlab.city_weather.domain.models.City
import ru.biozzlab.city_weather.domain.type.Failure
import ru.biozzlab.entities.Either
import ru.biozzlab.entities.None

class CityCacheImpl(private val localClient: LocalDB) : CityCache {
    override fun loadCityData(cityName: String): Either<Failure, City> {
        return Either.Right(convertEntityToModel(localClient.cityDataDao().getCityData(cityName)))
    }

    override fun saveCityData(data: City): Either<Failure, None> {
        localClient.cityDataDao().insert(convertModelToEntity(data))
        return Either.Right(None())
    }
}