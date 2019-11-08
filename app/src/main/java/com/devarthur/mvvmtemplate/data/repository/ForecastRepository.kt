package com.devarthur.mvvmtemplate.data.repository

import androidx.lifecycle.LiveData
import com.devarthur.mvvmtemplate.data.db.entity.CurrentWeatherEntry

interface ForecastRepository {

    suspend fun getCurrentWeather() : LiveData<CurrentWeatherEntry>
}