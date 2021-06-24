package com.example.diffutildemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val TAG = "MyViewModel"
class MyViewModel : ViewModel() {

    //The Details Class LiveData-List
    private val _dataSet: MutableLiveData<MutableList<Details>> = MutableLiveData()

    //The LiveData-Boolean var to check for the empty state of the newMutableList
    private val _fuckedUp = MutableLiveData<Boolean>().apply {
        value = false
    }


    //Backing Properties
    val dataSet: LiveData<MutableList<Details>>
        get() = _dataSet

    //Backing Properties
    val fuckedUp: LiveData<Boolean>
        get() = _fuckedUp

    //Adds The default objects to the List
    fun addNewObjects() {
        _dataSet.value = rawdata()
    }

    //Adds the new object instances to the dataSet
    fun importNewData() {


        //Adds the first Instance from the newMutableList
        if (!newMutableList.isEmpty()) {
            _dataSet.value = mutate(_dataSet.value, newMutableList[0])
            newMutableList.removeFirst()
            Log.e(TAG, newMutableList.toString())
        } else {
            _fuckedUp.value = true
        }
    }

    private fun mutate(value: MutableList<Details>?, details: Details): MutableList<Details>? {
         value!!.add(details)
         return value
    }


    //Instance
    fun rawdata() =
            mutableListOf(
                    Details(1, "Miku", "Nanako", "justmiku@nanako.com"),
                    Details(2, "Itsuki", "Nanako", "itsuki2405@nanako.com"),
                    Details(3, "Yotsuba", "Nanako", "strongYotsuba@nanako.com"),
                    Details(4, "Nino", "Nanako", "baby@nanako.com"),
                    Details(5, "Ichika", "Nanako", "Ichika@nanako.com"),
            )

    companion object {

        val newMutableList = mutableListOf(
                Details(6, "Eren", "Yaeger", "erenYaeger@survercorps.com"),
                Details(7, "Erwin", "Brown", "erwinBrown@survercorps.com"),
                Details(8, "Levi", "Ackermann", "leviAckermann@survercorps.com"))

    }

}