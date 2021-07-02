package com.example.retrofitfromrealapi.Data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInit {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://weatherbit-v1-mashape.p.rapidapi.com/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    val mWeatherApi : WeatherApi by lazy{
        retrofit.create(WeatherApi::class.java)
    }

}
