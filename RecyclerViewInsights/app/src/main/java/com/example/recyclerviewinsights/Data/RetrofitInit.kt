package com.example.recyclerviewinsights.Data

import android.app.DownloadManager
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInit {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://covid-19-data.p.rapidapi.com/country/all/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    val api : CovidRequestApi by lazy {
        retrofit.create(CovidRequestApi::class.java)
    }
}