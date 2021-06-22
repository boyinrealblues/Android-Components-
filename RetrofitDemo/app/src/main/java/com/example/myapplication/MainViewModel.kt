package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository : Repository) : ViewModel() {

    private var cnt =0
    private val _retro : MutableLiveData<List<Post>> = MutableLiveData()

    private val _current : MutableLiveData<Post> = MutableLiveData()

    val current : LiveData<Post>
        get() = _current

init{
    getData()
}


    fun changeData(){
        if(cnt < _retro.value!!.size){
            _current.value = _retro.value!!.get(cnt)
            cnt++
        }else {
            cnt = 0
            _current.value = _retro.value!!.get(cnt)

        }
    }


    fun  getData(){
        viewModelScope.launch{
            _retro.value = repository.getPost()
        }
    }

}