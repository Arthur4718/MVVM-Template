package com.devarthur.mvvmtemplate.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//* Created by Arthur Gomes at 2019-10-06 20:30 - contact me at devarthur4718@gmail.com.br


@Database(
    entities = [CurrentWeatherDAO::class],
    version = 1
)
abstract class ForecastDatabase : RoomDatabase()  {
    abstract fun currentWeatherDao() : CurrentWeatherDAO

    companion object{

        @Volatile
        private var instance : ForecastDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context : Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }

        }

        private fun buildDatabase(context : Context) =
            Room.databaseBuilder(context.applicationContext,
                ForecastDatabase::class.java, "forecast.db")
                .build()
    }
}