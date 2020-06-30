package com.github.udioshi85.cleanarchitecture.manager

import com.github.udioshi85.cleanarchitecture.CleanArchApplication
import java.io.File

object StorageManager {

    private val externalStorageDirectory = CleanArchApplication.appContext.getExternalFilesDir(null)?.apply {
        mkdirs()
    }
    private val temporaryStorageDirectory = File(externalStorageDirectory, "/tmp").apply {
        mkdirs()
    }

    fun saveTemporaryInDisk() {

    }
}