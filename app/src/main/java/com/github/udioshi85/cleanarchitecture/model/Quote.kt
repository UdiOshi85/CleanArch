package com.github.udioshi85.cleanarchitecture.model

import com.github.udioshi85.cleanarchitecture.recycling.AdapterDataType
import com.github.udioshi85.cleanarchitecture.recycling.TypeFactory
import com.google.gson.annotations.SerializedName

data class Quote(@SerializedName("_id") val id: String, val quoteText: String, val quoteAuthor: String): AdapterDataType {

    private val uniqueId = System.identityHashCode(this)

    override fun type(typeFactory: TypeFactory): Int = typeFactory.type(this)
    override fun uniqueId(): Int = uniqueId


}