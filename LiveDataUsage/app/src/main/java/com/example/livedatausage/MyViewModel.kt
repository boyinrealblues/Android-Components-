package com.example.livedatausage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val TAG = "MyViewModel"
class MyViewModel : ViewModel(){
    private val _data : MutableLiveData<MutableList<Int>> = MutableLiveData()
    val data
    get()=_data

    fun defaultData()
    {
        _data.value = MutableList(30,{i->i*1})
    }

    fun addMoreData()
    {
            if(!newList.isEmpty()) {
                _data.value = maker(_data.value, newList[0])
                newList.removeAt(0)
                Log.e(TAG,newList.toString())
       }
      }

    private fun maker(value: MutableLi st<Int>?, i: Int): MutableList<Int>? {
        value!!.add(i)
        return value
    }

    companion object{
        val newList = MutableList(10,{index-> index+31 })
    }
}