package com.github.udioshi85.cleanarchitecture.manager

import androidx.preference.PreferenceManager
import com.github.udioshi85.cleanarchitecture.CleanArchApplication

object Prefs {

    private val preferenceManager = PreferenceManager.getDefaultSharedPreferences(CleanArchApplication.appContext)

}