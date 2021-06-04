package com.example.livedatastarter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val editTextView = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        val stopButton = findViewById<Button>(R.id.button2)


        val model = ViewModelProvider(this).get(MainActivityViewModel::class.java)       //MainActivityViewModel object

        model.getSeconds().observe(this , Observer {
            textView.text = it.toString()
        })

        model.getFinished().observe(this, Observer {
            if (it)
                Toast.makeText(this, "Count Down Over", Toast.LENGTH_SHORT).show()
        })

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val userText = editTextView.text.toString()
                if (userText.isEmpty() || userText.length < 4) {
                    Toast.makeText(baseContext, "Invalid Input", Toast.LENGTH_SHORT).show()
                }else
                {
                    model.timerValue.value = userText.toLong()
                    model.startTimer()
                }
            }
        })

        stopButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                model.stopTimer()
                textView.setText("0")
            }
        })




    }
}