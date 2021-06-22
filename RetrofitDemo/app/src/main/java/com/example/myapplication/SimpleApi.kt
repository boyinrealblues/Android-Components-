package com.example.myapplication

import retrofit2.http.GET

interface SimpleApi {
    @GET("posts")
    suspend fun getPost() : List<Post>
}