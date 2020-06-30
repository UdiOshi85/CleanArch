package com.github.udioshi85.cleanarchitecture.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.udioshi85.cleanarchitecture.Resource
import com.github.udioshi85.cleanarchitecture.model.Quote
import com.github.udioshi85.cleanarchitecture.model.Quotes
import com.github.udioshi85.cleanarchitecture.network.services.QuoteGardenService
import com.github.udioshi85.cleanarchitecture.recycling.AdapterDataType


import kotlinx.coroutines.launch

class QuoteGardenViewModel(private val quoteGardenService: QuoteGardenService): ViewModel() {

    val mainLiveData = MutableLiveData<Resource<Any>>()

    var quotes: Quotes? = null
    var isLoading = false
    val isLastPage = quotes?.isLastPage() ?: false

    fun loadQuotes(fromPagination: Boolean, page: Int) {
        isLoading = true
        viewModelScope.launch {
            if (!fromPagination) {
                quotes?.let {
                    postResults(ACTION_LOAD_QUOTES_FIRST_PAGE, it.quotes)

                } ?: kotlin.run {
                    loadNextPage(1, ACTION_LOAD_QUOTES_FIRST_PAGE)
                }

            } else {
                loadNextPage(page, ACTION_LOAD_QUOTES_PAGINATION)
            }
        }
    }

    private suspend fun loadNextPage(page: Int, actionType: Int) {
        isLoading = true
        mainLiveData.postValue(Resource.loading(actionType))

        val response = quoteGardenService.getAllQuotes(page, 10)

        if (response.isSuccessful) {
            val newResponse = response.body()!!

            if (quotes == null) {
                quotes = newResponse
                postResults(actionType, newResponse.quotes)
            } else {
                quotes?.currentPage = newResponse.currentPage
                quotes?.totalPages = newResponse.totalPages
                quotes?.quotes!!.addAll(newResponse.quotes)
                postResults(actionType, newResponse.quotes)
            }

        } else {
            mainLiveData.postValue(Resource.error(actionType, response.errorBody()))
        }
    }

    private fun postResults(actionType: Int, newArray: ArrayList<Quote>) {
        val items = arrayListOf<AdapterDataType>()

        items.addAll(newArray)
        mainLiveData.postValue(Resource.success(actionType, items))
        isLoading = false
    }


    companion object {
        const val ACTION_LOAD_QUOTES_FIRST_PAGE = 0
        const val ACTION_LOAD_QUOTES_PAGINATION = 1
    }
}