package com.example.retrofitfromrealapi.Data

data class Weather(
    val country_code : String,
    val lon : Double ,
    val timezone : String ,
    val lat : Double ,
    val alerts : List<String>,
    val city_name : String,
    val state_code : String
)
