package com.github.udioshi85.cleanarchitecture.network

import com.github.udioshi85.cleanarchitecture.model.QuoteEndpoint
import com.github.udioshi85.cleanarchitecture.model.TimeSeriesIntraday
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlphaVantageService {
    @GET("query?function=GLOBAL_QUOTE")
    suspend fun getGlobalQuote(@Query("symbol") symbol: String, @Query("apikey") apiKey: String = RetrofitManager.API_KEY): Response<QuoteEndpoint>

    @GET("query?function=TIME_SERIES_INTRADAY")
    suspend fun getTimeSeriesIntraday(@Query("symbol") symbol: String, @Query("interval") interval: String = "5min", @Query("apikey") apiKey: String = RetrofitManager.API_KEY): Response<TimeSeriesIntraday>
}