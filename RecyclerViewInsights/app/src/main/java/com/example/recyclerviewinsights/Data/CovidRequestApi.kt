package com.example.recyclerviewinsights.Data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface CovidRequestApi {
    @Headers("x-rapidapi-key : 6e63eb0772msh8832a2efeac5294p13ab39jsnd3ad26b7654b" , "x-rapidapi-host : covid-19-data.p.rapidapi.com")
    @GET()
    suspend fun getAllList(): Call<List<Covid>>
}