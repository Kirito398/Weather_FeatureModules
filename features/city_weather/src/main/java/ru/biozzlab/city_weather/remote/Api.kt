package ru.biozzlab.city_weather.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.biozzlab.city_weather.remote.models.CityGsonModel

interface Api {

    @GET(ApiConstantsUtils.GET_WEATHER)
    fun getCity(
        @Query("q")
        cityName: String,
        @Query("APPID")
        key: String,
        @Query("units")
        metric: String
    ): Call<CityGsonModel>
}