package com.devarthur.mvvmtemplate.data.response.network

import com.devarthur.mvvmtemplate.data.db.entity.CurrentWeatherEntry
import com.devarthur.mvvmtemplate.data.db.entity.Location
import com.devarthur.mvvmtemplate.data.db.entity.Request
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    val request: Request,
    val location: Location,

    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)