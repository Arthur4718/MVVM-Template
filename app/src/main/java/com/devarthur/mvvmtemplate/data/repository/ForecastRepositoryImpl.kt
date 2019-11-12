package com.devarthur.mvvmtemplate.data.repository

import androidx.lifecycle.LiveData
import com.devarthur.mvvmtemplate.data.db.MyWeatherDAO
import com.devarthur.mvvmtemplate.data.db.entity.CurrentWeatherEntry
import com.devarthur.mvvmtemplate.data.network.WeatherNetworkDataSource
import com.devarthur.mvvmtemplate.data.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.ZonedDateTime
import java.util.*

class ForecastRepositoryImpl(
    private val currentWeatherDAO: MyWeatherDAO,
    private val weatherNetworkDataSource: WeatherNetworkDataSource
) : ForecastRepository {

    init{
        weatherNetworkDataSource.downloadedCurrentWeather.observeForever { newCurrentWeather ->
            persistFetchedCurrentWeather(newCurrentWeather)
        }
    }

    override suspend fun getCurrentWeather(): LiveData<CurrentWeatherEntry> {
            return withContext(Dispatchers.IO){
                initWeatherData()
                return@withContext currentWeatherDAO.getWeather()
            }
    }
    private fun persistFetchedCurrentWeather(fetchedWeater: CurrentWeatherResponse) {

        GlobalScope.launch(Dispatchers.IO) {
            currentWeatherDAO.upsert(fetchedWeater.currentWeatherEntry)
        }

    }

    private suspend fun initWeatherData() {
        if(isFetchCurrentNeeded(ZonedDateTime.now().minusHours(1)))
            fetchCurrentWeather()

    }

    private suspend fun fetchCurrentWeather(){
        weatherNetworkDataSource.fetchCurrentWeather(
            "Los Angeles",
            Locale.getDefault().language
        )
    }

    private fun isFetchCurrentNeeded(lastFetchTime : ZonedDateTime) : Boolean{
        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
        return lastFetchTime.isBefore(thirtyMinutesAgo)

    }
}