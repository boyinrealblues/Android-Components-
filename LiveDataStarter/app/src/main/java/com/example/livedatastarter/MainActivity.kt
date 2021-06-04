package com.example.livedatastarter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val model = ViewModelProvider(this).get(MainActivityViewModel::class.java)       //MainActivityViewModel object

        val textView = findViewById<TextView>(R.id.textView)

        model.startTimer()                     //Start Timer

        model.getSeconds().observe(this , Observer {
            textView.text = it.toString()
        })

        model.getFinished().observe(this, Observer {
            if (it)
                Toast.makeText(this, "Count Down Over", Toast.LENGTH_SHORT).show()
        })

    }
}