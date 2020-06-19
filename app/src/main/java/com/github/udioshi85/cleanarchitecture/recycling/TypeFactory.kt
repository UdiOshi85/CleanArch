package com.github.udioshi85.cleanarchitecture.recycling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup

interface TypeFactory {

    abstract fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, type: Int): BaseViewHolder<*>?

    abstract fun getCommonData(): Bundle?

}