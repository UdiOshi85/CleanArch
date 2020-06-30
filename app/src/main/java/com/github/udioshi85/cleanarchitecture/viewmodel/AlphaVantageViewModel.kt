package com.github.udioshi85.cleanarchitecture.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.udioshi85.cleanarchitecture.Resource
import kotlinx.coroutines.async

import kotlinx.coroutines.launch

class AlphaVantageViewModel(): ViewModel() {

    val mainLiveData = MutableLiveData<Resource<Any>>()

    fun chainRequests() {
        viewModelScope.launch {
//            val fvrr = alphaVantageRepository.getGlobalQuote("FVRR").body()
//            val ibm = alphaVantageRepository.getGlobalQuote("IBM").body()
//            val amzn = alphaVantageRepository.getGlobalQuote("AMZN").body()
//            val goog = alphaVantageRepository.getGlobalQuote("GOOG").body()
//
//            processResults(fvrr, ibm, amzn, goog)
        }
    }

    fun parallelRequest() {
        viewModelScope.launch {
//            val fvrrTask = async { alphaVantageRepository.getGlobalQuote("FVRR").body() }
//            val ibmTask = async { alphaVantageRepository.getGlobalQuote("IBM").body() }
//            val amznTask = async { alphaVantageRepository.getGlobalQuote("AMZN").body() }
//            val googTask = async { alphaVantageRepository.getGlobalQuote("GOOG").body() }
//
//            processResults(fvrrTask.await(), ibmTask.await(), amznTask.await(), googTask.await())
        }
    }


}