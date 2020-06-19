package com.github.udioshi85.cleanarchitecture.recycling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup

open class BaseFactory: TypeFactory  {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, type: Int): BaseViewHolder<*>? = null

    override fun getCommonData(): Bundle? = null
}