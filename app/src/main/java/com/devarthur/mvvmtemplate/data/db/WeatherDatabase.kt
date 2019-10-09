package com.devarthur.mvvmtemplate.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devarthur.mvvmtemplate.data.db.entity.CurrentWeatherEntry

//* Created by Arthur Gomes at 2019-10-08 21:46 - contact me at devarthur4718@gmail.com.br


@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1
)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun currentWeatherDAO() : MyWeatherDAO


    companion object{
      @Volatile private var instance : WeatherDatabase? = null
        private val LOCK = Any()


        operator fun invoke(context : Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context : Context) =
            Room.databaseBuilder(context.applicationContext
                , WeatherDatabase::class.java,
                "forecast.db").build()

    }

}