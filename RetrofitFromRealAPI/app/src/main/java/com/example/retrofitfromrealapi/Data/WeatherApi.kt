package com.example.retrofitfromrealapi.Data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApi {

    @Headers("x-rapidapi-key : 6e63eb0772msh8832a2efeac5294p13ab39jsnd3ad26b7654b", "x-rapidapi-host : weatherbit-v1-mashape.p.rapidapi.com")
    @GET("alerts")
    suspend fun getForecast(@Query("lat") lat : Double , @Query("lon") lon : Double): Call<Weather>

}