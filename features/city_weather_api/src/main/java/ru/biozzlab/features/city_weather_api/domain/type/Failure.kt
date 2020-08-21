package ru.biozzlab.features.city_weather_api.domain.type

sealed class Failure {
    object NetworkConnectionError : Failure()
    object ServerError : Failure()
}