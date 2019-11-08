package com.devarthur.mvvmtemplate.data.network

import androidx.lifecycle.LiveData
import com.devarthur.mvvmtemplate.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {

    val downloadedCurrentWeather : LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location : String,
        languageCode : String
    )
}