package ru.biozzlab.city_weather.remote

import ru.biozzlab.city_weather.data.CityRemote
import ru.biozzlab.city_weather.domain.models.City
import ru.biozzlab.city_weather.domain.type.Failure
import ru.biozzlab.entities.Either

class CityRemoteImpl(private val client: Api, private val request: Request) : CityRemote {
    override fun loadCityData(cityName: String): Either<Failure, City> {
        return request.make(client.getCity(cityName, ApiConstantsUtils.KEY, ApiConstantsUtils.METRIC)) {
            City(
                it.name ?: "",
                it.weather[0].main,
                "${it.main.tempMin.toInt()} / ${it.main.tempMax.toInt()}",
                it.weather[0].icon,
                it.main.temp.toInt().toString(),
                it.main.pressure.toInt().toString(),
                it.main.humidity.toString(),
                it.weather[0].description,
                it.wind.speed.toInt().toString()
            )
        }
    }
}