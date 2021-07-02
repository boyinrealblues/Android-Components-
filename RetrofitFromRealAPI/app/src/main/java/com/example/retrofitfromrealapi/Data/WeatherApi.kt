package com.example.retrofitfromrealapi.Data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApi {
    @GET("alerts")
    suspend fun getForecast(@Query("lat") lat : Double , @Query("lon") lon : Double):Call<Weather>

}