package com.devarthur.mvvmtemplate.ui.weather.current

import androidx.lifecycle.ViewModel
import com.devarthur.mvvmtemplate.data.repository.ForecastRepository
import com.devarthur.mvvmtemplate.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    //NOT USED WITH THE CURRENT ENDPOINT
//    val isMetric : Boolean
//        get() = true
    val weather by lazyDeferred() {
        forecastRepository.getCurrentWeather()
    }

}
