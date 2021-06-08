package com.example.guesstheword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.guesstheword.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit private var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

      setSupportActionBar(binding.toolbar)

      val host = supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment? ?: return



    }
}