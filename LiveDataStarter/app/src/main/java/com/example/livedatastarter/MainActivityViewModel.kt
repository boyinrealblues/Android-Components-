package com.example.livedatastarter

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel()
{
    lateinit private var timer : CountDownTimer

     private var seconds = MutableLiveData<Int>()                       //Note- MutableLiveData<Int> Object

     private var finished = MutableLiveData<Boolean>()

    fun getSeconds() : LiveData<Int> = seconds                     //Getters

    fun getFinished() : LiveData<Boolean> = finished

    fun startTimer() {                         //Function to start the timer
        timer = object : CountDownTimer(10000,1000){         //<millisInFuture : Start Limit of Timer> , <countDownInterval : Step Interval>

            override fun onTick(millisUntilFinished: Long) {  //Called after evey second (1000millis)

                val p = millisUntilFinished/1000

                seconds.value = p.toInt()

            }

            override fun onFinish() { //Called when timer reaches 0

                finished.value = true

            }

        }.start()
    }
}