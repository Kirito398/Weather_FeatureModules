package ru.biozzlab.city_weather.domain.type

sealed class Failure {
    object NetworkConnectionError : Failure()
    object ServerError : Failure()
}