package ru.biozzlab.city_weather.remote.models

class MainGsonModel(
    val temp: Float,
    val pressure: Float,
    val humidity: Int,
    val tempMin: Float,
    val tempMax: Float
)