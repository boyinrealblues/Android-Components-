package com.example.recyclerviewinsights.Data

data class Covid(
    val country : String,
    val code : String,
    val confirmed : Long,
    val recovered : Long ,
    val critical : Long ,
    val latitude : Double ,
    val longtitude : Double,
    val lastChange : String,
    val lstUpdate : String
    )
