package com.example.guesstheword

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class GameFragmentViewModel : ViewModel() {

    companion object{
        const val ONE_SECOND : Long = 1000
        const val TIMER_LIMIT : Long = 10000
    }

    private lateinit var timer : CountDownTimer
    private val _word = MutableLiveData<String>()    //current word as liveData
       val word
       get() : LiveData<String> = _word

    private val _score = MutableLiveData<Int>()      //current score as liveData
       val score
       get() : LiveData<Int> = _score

    private val _check = MutableLiveData<Boolean>()   //variable to transfer the score to the next fragment when words become empty
        val check
        get() : LiveData<Boolean> = _check

    private var _stringTime = MutableLiveData<String>()
            val stringTime : LiveData<String>
                get() = _stringTime

    private val currentList : MutableList<String>

    init {
        currentList = listOfAnimals()           //current list initialised
        _word.value = currentList[0]                         //word initialised to first word of the list
        _score.value = 0                        //score initialised to 0
        _check.value = false
         timerStart()
    }

    fun onGotIt(){

        _score.value = _score.value!!+1
        updateWord()

    }


    fun onSkip(){

        _score.value = _score.value!!-1
        updateWord()

    }

    fun updateWord(){
        if(currentList.isEmpty()){
           _check.value = true
        }else
        {
                _word.value = currentList[0]
                currentList.removeAt(0)
                timerStop()
                timerStart()
        }
    }



    fun listOfAnimals() = mutableListOf(
            "Elephant",
            "Giraffe",
            "Zebra",
            "Anaconda",
            "Monkey",
            "Polar Bear",
            "Panda",
            "Mongoose",
            "Hippo",
            "Snakes",
            "Red Panda",
            "Tiger",
            "Cheetah",
            "Baboon",
            "Tiger",
            "Crocodile",
            "Reindeer",
            "Raccoon",
            "Beaver",
            "Orangutan"
    )

    fun timerStart(){
        timer =
                object : CountDownTimer(TIMER_LIMIT, ONE_SECOND){

                    override fun onTick(millisUntilFinished: Long) {
                        _stringTime.value = DateUtils.formatElapsedTime(millisUntilFinished/1000)
                    }

                    override fun onFinish() {

                         _score.value = _score.value!!-1
                         updateWord()
                    }

                }.start()
    }

    fun timerStop(){
        timer.cancel()
        _stringTime.value = DateUtils.formatElapsedTime(0)
    }


}