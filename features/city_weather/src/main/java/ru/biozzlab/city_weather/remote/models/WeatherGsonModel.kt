package ru.biozzlab.city_weather.remote.models

data class WeatherGsonModel(
    val main: String,
    val description: String,
    val icon: String
)