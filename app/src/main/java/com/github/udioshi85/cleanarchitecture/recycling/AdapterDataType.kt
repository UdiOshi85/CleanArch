package com.github.udioshi85.cleanarchitecture.recycling

import java.io.Serializable

interface AdapterDataType: Serializable {
    fun type(typeFactory: TypeFactory): Int
    fun uniqueId(): Int
}