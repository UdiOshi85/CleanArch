package com.github.udioshi85.cleanarchitecture.network.services

import com.github.udioshi85.cleanarchitecture.model.Quote
import com.github.udioshi85.cleanarchitecture.model.Quotes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface QuoteGardenService {

    @GET("quotes/random")
    suspend fun getRandomQuote(): Response<Quote>

    @GET("authors/{author}")
    suspend fun getQuotesByAuthor(@Path("author") author: String, @Query("page") page: Int, @Query("limit") limit: Int): Response<Quotes>

    @GET("genre/{genre_name")
    suspend fun getQuotesByGenre(@Path("genre_name") genreName: String, @Query("page") page: Int, @Query("limit") limit: Int): Response<Quotes>

    @GET("quotes")
    suspend fun getAllQuotes(@Query("page") page: Int, @Query("limit") limit: Int): Response<Quotes>
}