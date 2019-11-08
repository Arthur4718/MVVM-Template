package com.devarthur.mvvmtemplate.data.repository

import androidx.lifecycle.LiveData
import com.devarthur.mvvmtemplate.data.db.MyWeatherDAO
import com.devarthur.mvvmtemplate.data.db.entity.CurrentWeatherEntry
import com.devarthur.mvvmtemplate.data.network.WeatherNetworkDataSource

class ForecastRepositoryImpl(
    private val currentWeatherDAO: MyWeatherDAO,
    private val weatherNetworkDataSource: WeatherNetworkDataSource
) : ForecastRepository {

    override suspend fun getCurrentWeather(): LiveData<CurrentWeatherEntry> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}