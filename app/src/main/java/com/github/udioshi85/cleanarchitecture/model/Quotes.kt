package com.github.udioshi85.cleanarchitecture.model

class Quotes(val statusCode: Int, var totalPages: Int, var currentPage: Int, var quotes: ArrayList<Quote>) {
    fun isLastPage() = currentPage == totalPages
}


