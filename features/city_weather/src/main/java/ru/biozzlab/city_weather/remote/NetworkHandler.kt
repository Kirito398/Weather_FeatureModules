package ru.biozzlab.city_weather.remote

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetworkHandler(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnected
}

val Context.networkInfo: NetworkInfo? get() =
    (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo