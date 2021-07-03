package com.example.retrofitfromrealapi.UI

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitfromrealapi.R
import com.example.retrofitfromrealapi.databinding.ActivityMainBinding
import com.google.android.material.shape.CornerFamily

class MainActivity : AppCompatActivity() {

    lateinit private var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val model = ViewModelProvider(this).get(WeatherViewModel::class.java)
        val intent = Intent(Intent.ACTION_VIEW)

        binding.weatherGetButton.setOnClickListener {
            val lat = binding.latitudeEditText.text.toString()
            val longt = binding.longtitudeEditText.text.toString()
            intent.data = Uri.parse("geo:${lat},${longt}")
            model.getWeatherForeCast(lat.toDouble(),longt.toDouble())
            binding.progressBar.visibility = View.VISIBLE
        }
        model.weatherForecast.observe(this,{
            val sb = StringBuffer()
            sb.append(it.city_name.toUpperCase()+"\n"+it.country_code+"\n"+it.lat+"\n"+it.lon+"\n"+it.city_name+"\n"+it.state_code)
            binding.weatherText.setText(sb)
            binding.progressBar.visibility= View.INVISIBLE
        })
        binding.navigate.setOnClickListener {

            startActivity(intent)       }
        }
    }
