package com.example.livedatausage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livedatausage.databinding.ActivityMainBinding

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    lateinit private var binding : ActivityMainBinding

    lateinit private var model : MyViewModel

    private val mAdapter by lazy{
        MyAdapter()
    }

    lateinit var x:List<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity) //use this.context as arg
            adapter = mAdapter
        }

    }
}