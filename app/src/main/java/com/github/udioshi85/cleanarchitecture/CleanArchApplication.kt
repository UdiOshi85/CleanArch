package com.github.udioshi85.cleanarchitecture

import android.app.Application
import android.content.Context

class CleanArchApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object {
        lateinit var appContext: Context
    }
}