package com.devarthur.mvvmtemplate.data

import android.util.Log
import com.devarthur.mvvmtemplate.data.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "f2b8eb4d871f1e8eb89a27fd147a67cc"

interface ApixuWeatherApiService {

    // http://api.weatherstack.com/current?access_key=f2b8eb4d871f1e8eb89a27fd147a67cc&query=Sao%Paulo&lang=pt-br


    @GET("current.json")
    fun getCurrentWeather(
        @Query("key") apikey : String = API_KEY,
        @Query("q") location : String = "London",
        @Query("lang") languague : String = "en"
    ) : Deferred<CurrentWeatherResponse>


    companion object{
         operator fun invoke() : ApixuWeatherApiService{
             val requestInterceptor = Interceptor{ chain ->

                 val url = chain.request()
                     .url()
                     .newBuilder()
                     .build()

                 val request = chain.request()
                     .newBuilder()
                     .url(url)
                     .build()

                 return@Interceptor chain.proceed(request)


             }


             val okHttpClient = OkHttpClient.Builder()
                 .addInterceptor(requestInterceptor)
                 .build()

             return Retrofit.Builder()
                 .client(okHttpClient)
                 .baseUrl("https://api.apixu.com/v1/")
                 .addCallAdapterFactory(CoroutineCallAdapterFactory())
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()
                 .create(ApixuWeatherApiService::class.java)


         }
    }
}