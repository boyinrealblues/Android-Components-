package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository : Repository) : ViewModel() {

    private val _retro : MutableLiveData<List<Post>> = MutableLiveData()

    val retro : LiveData<List<Post>>
    get() = _retro

    fun  getData(){
        viewModelScope.launch{
            _retro.value = repository.getPost()
        }

    }

}