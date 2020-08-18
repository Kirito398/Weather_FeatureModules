package ru.biozzlab.city_weather.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.biozzlab.city_weather.cache.DataBaseConstants

@Entity(tableName = DataBaseConstants.TABLE_CITY_DATA)
class CityEntity (
    val cityName: String,
    val weather: String,
    val tempMinMax: String,
    val icon: String,
    val temp: String,
    val pressure: String,
    val humidity: String,
    val description: String,
    val windSpeed: String
) {
    @PrimaryKey
    var id: Long = 0
}