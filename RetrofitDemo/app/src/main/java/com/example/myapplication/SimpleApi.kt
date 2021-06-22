package com.example.myapplication

import retrofit2.http.GET

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost() : Post
}