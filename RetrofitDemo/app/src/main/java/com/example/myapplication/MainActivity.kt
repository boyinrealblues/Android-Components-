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

          Log.e("BODY",it.body)
          Log.e("TITLE",it.title)
          Log.e("ID",it.id.toString())
          Log.e("USERID",it.userId.toString())
           })

        viewModel.getData()

    }
}