package com.github.udioshi85.cleanarchitecture.recycling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.udioshi85.cleanarchitecture.model.Loading
import com.github.udioshi85.cleanarchitecture.model.Quote


open class BaseFactory: TypeFactory  {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, type: Int): BaseViewHolder<*>? = null

    override fun getCommonData(): Bundle? = null

    override fun type(quote: Quote): Int = 0
    override fun type(loading: Loading): Int = 0


}