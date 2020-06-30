package com.github.udioshi85.cleanarchitecture.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.udioshi85.cleanarchitecture.Resource
import com.github.udioshi85.cleanarchitecture.Status

abstract class BaseActivity: AppCompatActivity(), Observer<Resource<Any>> {

    override fun onChanged(resource: Resource<Any>?) {
        when (resource?.status) {
            Status.LOADING -> onDataLoading(resource)
            Status.ERROR -> onDataError(resource)
            Status.SUCCESS -> onDataFetched(resource)
        }
    }

    abstract fun onDataLoading(resource: Resource<Any>)

    abstract fun onDataError(resource: Resource<Any>)

    abstract fun onDataFetched(resource: Resource<Any>)


}