package com.github.udioshi85.cleanarchitecture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel: ViewModel() {

    val mainLiveData = MutableLiveData<Resource<Any>>()

    companion object {
        const val ACTION_TYPE_ONE = 0
    }

}