package com.example.myapplication

class Repository {

    suspend fun getPost():List<Post>{
       return  RetrofitInstance.api.getPost()
    }

}