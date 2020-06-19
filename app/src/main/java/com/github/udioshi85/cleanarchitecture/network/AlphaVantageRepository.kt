package com.github.udioshi85.cleanarchitecture.network

class AlphaVantageRepository(val alphaVantageService: AlphaVantageService) {

    suspend fun getGlobalQuote(symbol: String) = alphaVantageService.getGlobalQuote(symbol)
    suspend fun getTimeSeriesIntraday(symbol: String) = alphaVantageService.getTimeSeriesIntraday(symbol)
}