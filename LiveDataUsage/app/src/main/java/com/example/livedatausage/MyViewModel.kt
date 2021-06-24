package com.example.livedatausage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val TAG = "MyViewModel"
class MyViewModel : ViewModel(){
    var c=0
    private val _data : MutableLiveData<MutableList<Int>> = MutableLiveData()
    val data
    get()=_data

    fun defaultData()
    {
        _data.value = MutableList(30,{i->i*1})
    }

    fun addMoreData()
    {
        val newList = MutableList(10,{index-> index+31 }) //index is a lambda param corresponding to the index of each element

        Log.e(TAG,newList[1].toString())
        newList.removeAt(0)
        Log.e(TAG,newList.toString())
        Log.e(TAG,newList[1].toString())
        return
                //P : _data.value.add(element)does not change the value thats why we used a function here
            _data.value = maker(_data.value,newList[c])
            c++
    }

    private fun maker(value: MutableList<Int>?, i: Int): MutableList<Int>? {
        value!!.add(i)
        return value
    }
}