package com.github.udioshi85.cleanarchitecture.model

import com.github.udioshi85.cleanarchitecture.recycling.AdapterDataType
import com.github.udioshi85.cleanarchitecture.recycling.TypeFactory

class Loading: AdapterDataType {

    private val uniqueId = System.identityHashCode(this)

    override fun type(typeFactory: TypeFactory): Int = typeFactory.type(this)
    override fun uniqueId(): Int = uniqueId

}