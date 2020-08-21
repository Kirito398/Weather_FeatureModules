package ru.biozzlab.features.city_weather_api.domain.models

data class City(
    val cityName: String,
    val weather: String,
    val tempMinMax: String,
    val icon: String,
    val temp: String,
    val pressure: String,
    val humidity: String,
    val description: String,
    val windSpeed: String
)