package ru.biozzlab.city_weather.remote

import retrofit2.Call
import retrofit2.Response
import ru.biozzlab.features.city_weather_api.domain.type.Failure
import ru.biozzlab.entities.Either

class Request(private val networkHandler: NetworkHandler) {

    fun <T, R> make(call: Call<T>, transform: (T) -> R): Either<Failure, R> {
        return when (networkHandler.isConnected) {
            true -> execute(call, transform)
            false, null -> Either.Left(Failure.NetworkConnectionError)
        }
    }

    private fun <T, R> execute(call: Call<T>, transform: (T) -> R): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSucceed()) {
                true -> Either.Right(transform(response.body()!!))
                false -> Either.Left(Failure.ServerError)
            }
        } catch (e: Throwable) {
            Either.Left(Failure.ServerError)
        }
    }
}

fun <T> Response<T>.isSucceed(): Boolean = isSuccessful && body() != null