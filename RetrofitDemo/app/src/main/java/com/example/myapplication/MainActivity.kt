package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val repository = Repository()
         val viewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel(repository)::class.java)

        viewModel.retro.observe(this, {

            for(i in  it){
                Log.e("BODY",i.body)
                Log.e("ID",i.id.toString())
                Log.e("TITLE",i.title)
                Log.e("UserId",i.userId.toString())
            }
        })

        viewModel.getData()

    }
}