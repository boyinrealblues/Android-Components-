package com.example.recyclerviewinsights.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewinsights.R
import com.example.recyclerviewinsights.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val mAdapter by lazy{
        CovidAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val model = ViewModelProvider(this).get(CovidViewModel::class.java)
        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CovidAdapter()
        }

        model.CountryDataLatest.observe(this , {
            mAdapter.submitList(it)
        })
    }
}