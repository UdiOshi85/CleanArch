package com.github.udioshi85.cleanarchitecture.recycling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.udioshi85.cleanarchitecture.model.Loading
import com.github.udioshi85.cleanarchitecture.model.Quote

interface TypeFactory {

    abstract fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, type: Int): BaseViewHolder<*>?

    abstract fun getCommonData(): Bundle?

    abstract fun type(quote: Quote): Int
    abstract fun type(loading: Loading): Int

}