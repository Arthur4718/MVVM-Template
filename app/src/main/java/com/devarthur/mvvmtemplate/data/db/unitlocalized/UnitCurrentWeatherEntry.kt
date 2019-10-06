package com.devarthur.mvvmtemplate.data.db.unitlocalized

//* Created by Arthur Gomes at 2019-10-06 20:03 - contact me at devarthur4718@gmail.com.br


interface UnitCurrentWeatherEntry {

    val observationTime: String
    val temperature: Int
    val weatherCode: Int
    val windSpeed: Int
    val windDir: String
    val feelslike: Int
    val precip: Double
    val visibility: Int

}