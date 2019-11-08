package com.devarthur.mvvmtemplate.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.devarthur.mvvmtemplate.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConectivityInterceptorImpl(
    context : Context
) : ConectivityInterceptor {


    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {

        if(!isOnline())
            throw NoConnectivityException()
        return chain.proceed(chain.request())
    }


    private fun isOnline() : Boolean{
        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
        as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected

    }
}