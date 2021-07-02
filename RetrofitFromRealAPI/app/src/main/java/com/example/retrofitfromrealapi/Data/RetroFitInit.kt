package com.example.retrofitfromrealapi.Data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInit {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor( object : Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain.request().newBuilder().addHeader("x-rapidapi-key","6e63eb0772msh8832a2efeac5294p13ab39jsnd3ad26b7654b").addHeader("x-rapidapi-host","weatherbit-v1-mashape.p.rapidapi.com").build()
                  return chain.proceed(request)
            }

        })
    }.build()

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://weatherbit-v1-mashape.p.rapidapi.com/").client(client).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val mWeatherApi : WeatherApi by lazy{
        retrofit.create(WeatherApi::class.java)
    }

}
