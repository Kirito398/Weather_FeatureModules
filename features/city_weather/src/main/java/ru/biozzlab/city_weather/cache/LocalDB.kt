package ru.biozzlab.city_weather.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.biozzlab.city_weather.cache.daos.CityDataDao
import ru.biozzlab.city_weather.cache.entities.CityEntity

@Database(
    entities = [CityEntity::class],
    version = DataBaseConstants.ROOM_DB_VERSION
)
abstract class LocalDB : RoomDatabase() {
    abstract fun cityDataDao(): CityDataDao
}