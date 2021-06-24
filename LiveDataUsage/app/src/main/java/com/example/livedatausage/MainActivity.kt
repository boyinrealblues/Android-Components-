package com.example.livedatausage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        model = ViewModelProvider(this).get(MyViewModel::class.java)

        model.data.observe(this,{
            Log.e(TAG,it.toString())
            mAdapter.setData(it)
        })

        model.defaultData()

        binding.addButton.setOnClickListener {
            if(model.c<10) {
                model.addMoreData()
            }
        }


        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(this.context) //use this.context as arg
            adapter = mAdapter
        }

    }
}