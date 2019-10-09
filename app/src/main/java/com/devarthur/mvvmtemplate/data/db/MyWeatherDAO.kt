package com.devarthur.mvvmtemplate.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devarthur.mvvmtemplate.data.db.entity.CURRENT_WEATHER_ID
import com.devarthur.mvvmtemplate.data.db.entity.CurrentWeatherEntry

//Created by Arthur Gomes - at 2019-10-08 21:40


@Dao
interface MyWeatherDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)


    @Query("select * from tab_current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeather(): LiveData<CurrentWeatherEntry>


}