package com.github.udioshi85.cleanarchitecture.network

import com.github.udioshi85.cleanarchitecture.network.services.QuoteGardenService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitManager {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    private val httpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

    private val retrofit = Retrofit.Builder().baseUrl("https://quote-garden.herokuapp.com/api/v2/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val quoteGardenService: QuoteGardenService = retrofit.create(QuoteGardenService::class.java)
}