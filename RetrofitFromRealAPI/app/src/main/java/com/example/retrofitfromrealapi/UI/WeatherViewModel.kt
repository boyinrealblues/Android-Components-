package com.example.retrofitfromrealapi.UI

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitfromrealapi.Data.RetroFitInit
import com.example.retrofitfromrealapi.Data.Weather
import com.example.retrofitfromrealapi.Data.WeatherApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel : ViewModel() {

    private val _weatherForecast : MutableLiveData<Weather> = MutableLiveData()
    val weatherForecast : LiveData<Weather>
    get() = _weatherForecast


    fun getWeatherForeCast(latitude : Double , longtitude : Double){
                 viewModelScope.launch{
                        _weatherForecast.value =
                            RetroFitInit.mWeatherApi.getForecast(latitude, longtitude)
                    }

        }

    }


