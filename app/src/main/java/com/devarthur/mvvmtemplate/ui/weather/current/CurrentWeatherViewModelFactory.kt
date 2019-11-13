package com.devarthur.mvvmtemplate.ui.weather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devarthur.mvvmtemplate.data.repository.ForecastRepository

//* Created by Arthur Gomes at 2019-11-12 21:56 - contact me at devarthur4718@gmail.com.br
class CurrentWeatherViewModelFactory(
    private val forecastRepository: ForecastRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(forecastRepository) as T
    }
}