package com.github.udioshi85.cleanarchitecture.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.udioshi85.cleanarchitecture.network.RetrofitManager
import com.github.udioshi85.cleanarchitecture.network.services.QuoteGardenService

class ViewModelFactory(): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuoteGardenViewModel::class.java)) {
            return QuoteGardenViewModel(RetrofitManager.quoteGardenService) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }

}