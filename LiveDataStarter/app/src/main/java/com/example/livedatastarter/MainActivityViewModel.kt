package com.example.livedatastarter

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*

private const val TAG = "MainActivityViewModel"
class MainActivityViewModel : ViewModel()
{

    lateinit var timer : CountDownTimer

     private var seconds = MutableLiveData<Int>()                       //Note- MutableLiveData<Int> Object

    var liveString = MutableLiveData<String>()

     private var finished = MutableLiveData<Boolean>()

    var timerValue = MutableLiveData<Long>()

    fun getSeconds() : LiveData<Int> = seconds                     //Getters

    fun getFinished() : LiveData<Boolean> = finished


    fun startTimer() {                         //Function to start the timer
        timer  = object : CountDownTimer(timerValue.value as Long,1000){         //<millisInFuture : Start Limit of Timer> , <countDownInterval : Step Interval>


            override fun onTick(millisUntilFinished: Long) {  //Called after evey second (1000millis)

                val p = millisUntilFinished/1000
                seconds.value = p.toInt()
        }

            override fun onFinish() { //Called when timer reaches 0

                finished.value = true

            }

        }.start()
    }

    fun stopTimer(){
        finished.value=true
        timer.cancel()
    }
}