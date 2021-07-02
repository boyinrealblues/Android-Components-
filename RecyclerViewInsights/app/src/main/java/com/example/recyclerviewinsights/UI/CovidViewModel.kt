package com.example.recyclerviewinsights.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewinsights.Data.Covid
import com.example.recyclerviewinsights.Data.RetrofitInit
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class CovidViewModel : ViewModel() {

    private val _CountryDataList : MutableLiveData<List<Covid>> = MutableLiveData()
    val CountryDataLatest : LiveData<List<Covid>>
    get() = _CountryDataList

     init{
         viewModelScope.launch {
             val call = RetrofitInit.api.getAllList()
                call.enqueue(object : retrofit2.Callback<List<Covid>>{
                    override fun onResponse(
                        call: Call<List<Covid>>,
                        response: Response<List<Covid>>
                    ) {
                        if(!response.isSuccessful)

                          _CountryDataList.value = response.body()
                    }

                    override fun onFailure(call: Call<List<Covid>>, t: Throwable) {

                    }

                })
         }
     }
}