package com.example.myapplication

class Repository {

    suspend fun getPost():Post{
       return  RetrofitInstance.api.getPost()
    }

}