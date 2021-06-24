package com.example.diffutildemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutildemo.databinding.ActivityMainBinding

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(){

    lateinit private var binding : ActivityMainBinding

    private val myAdapter by lazy{
        DetailAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //ViewBinding Initialization
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        //the adapter needs to be placed in the context where the list is updateed

        //ViewModel Initialization
        val model = ViewModelProvider(this).get(MyViewModel::class.java)

        //Adding default objects to the observer _dataSet
        model.addNewObjects()


        //Whenever the value changes update pass new list to the adapter
        model.dataSet.observe(this,{

            //It doesn't matter where you put the binding to recyclerview in the context
            Log.e(TAG,it.toString())
            myAdapter.setData(it)
            binding.recyclerView.adapter = myAdapter

        })

        //OnClick make the observer have a new list
        binding.addButton.setOnClickListener {
            model.importNewData()
        }

        //Checker observer for the empty-state of the newMutableList
        model.fuckedUp.observe(this, {
            if (it) {
                Toast.makeText(this, "No More Data Available", Toast.LENGTH_SHORT).show()
            }
        })

        //RecyclerView Init
        myAdapter.setData(mutableListOf(Details(6,"Itachi","Uchiha","sharinganUser1@akatsuki.com")))
    }

}