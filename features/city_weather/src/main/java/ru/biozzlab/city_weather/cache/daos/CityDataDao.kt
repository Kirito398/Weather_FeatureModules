package ru.biozzlab.city_weather.cache.daos

import androidx.room.*
import ru.biozzlab.city_weather.cache.DataBaseConstants
import ru.biozzlab.city_weather.cache.entities.CityEntity

@Dao
interface CityDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(city: CityEntity)

    @Update
    fun update(city: CityEntity)

    @Query("SELECT * FROM ${ DataBaseConstants.TABLE_CITY_DATA } WHERE cityName = :cityName")
    fun getCityData(cityName: String): CityEntity
}