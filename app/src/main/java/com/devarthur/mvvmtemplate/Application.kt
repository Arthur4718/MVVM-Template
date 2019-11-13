package com.devarthur.mvvmtemplate

import android.app.Application
import com.devarthur.mvvmtemplate.data.db.WeatherDatabase
import com.devarthur.mvvmtemplate.data.network.*
import com.devarthur.mvvmtemplate.data.repository.ForecastRepository
import com.devarthur.mvvmtemplate.data.repository.ForecastRepositoryImpl
import com.devarthur.mvvmtemplate.ui.weather.current.CurrentWeatherViewModel
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
//* Created by Arthur Gomes at 2019-11-11 22:34 - contact me at devarthur4718@gmail.com.br
class ForecastApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))
        //Get app context from kodein
        bind() from singleton {WeatherDatabase(instance()) }
        bind() from singleton { instance<WeatherDatabase>().currentWeatherDAO() }
        bind<ConectivityInterceptor>() with singleton { ConectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance()) }
        bind() from provider { CurrentWeatherViewModel(instance()) }
    }
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}