package com.github.udioshi85.cleanarchitecture.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.udioshi85.cleanarchitecture.network.AlphaVantageRepository
import com.github.udioshi85.cleanarchitecture.network.AlphaVantageService

class ViewModelFactory(private val alphaVantageService: AlphaVantageService): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlphaVantageViewModel::class.java)) {
            return AlphaVantageViewModel(AlphaVantageRepository(alphaVantageService)) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}