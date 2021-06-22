package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding
import java.lang.StringBuilder

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    lateinit private var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

         val repository = Repository()
         val viewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel(repository)::class.java)


        viewModel.getData()
        binding.next.setOnClickListener {
            viewModel.changeData()
        }

        viewModel.current.observe(this,{
            val sb : StringBuilder = StringBuilder()
            sb.append("UserID : "+it.userId.toString()+"\n")
            sb.append("ID : "+it.id.toString()+"\n")
            sb.append("Title : "+it.title+"\n")
            sb.append("Body : "+it.body+"\n")
            binding.text.setText(sb)
        })


    }
}