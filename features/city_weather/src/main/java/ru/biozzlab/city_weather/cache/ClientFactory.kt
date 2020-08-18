package ru.biozzlab.city_weather.cache

import android.content.Context
import androidx.room.Room

object ClientFactory {
    fun getClient(context: Context): LocalDB {
        return Room.databaseBuilder(
            context,
            LocalDB::class.java,
            DataBaseConstants.ROOM_DB_NAME
        ).build()
    }
}