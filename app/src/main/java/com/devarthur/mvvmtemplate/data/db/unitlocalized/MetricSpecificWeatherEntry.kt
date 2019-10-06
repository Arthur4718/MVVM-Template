package com.devarthur.mvvmtemplate.data.db.unitlocalized

//* Created by Arthur Gomes at 2019-10-06 20:11 - contact me at devarthur4718@gmail.com.br
class MetricSpecificWeatherEntry (
    override val observationTime: String,
    override val temperature: Int,
    override val weatherCode: Int,
    override val windSpeed: Int,
    override val windDir: String,
    override val feelslike: Int,
    override val precip: Double,
    override val visibility: Int


) : UnitCurrentWeatherEntry