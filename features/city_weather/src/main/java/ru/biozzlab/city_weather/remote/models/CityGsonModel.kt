package ru.biozzlab.city_weather.remote.models

import java.util.*

data class CityGsonModel(
    val weather: List<WeatherGsonModel>,
    val main: MainGsonModel,
    val wind: WindGsonModel,
    val dt: Long,
    val name: String?
) {
    fun getData(): Calendar {
        val date = Calendar.getInstance()
        date.timeInMillis = dt*1000
        return date
    }
}