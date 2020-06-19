package com.github.udioshi85.cleanarchitecture.recycling

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Base class for supporting multi types views
 */
abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    /**
     * Called when View is ready to bind with.
     */
    abstract fun onBindViewHolder(data: T, commonData: Bundle? = null, payloads: MutableList<Any>? = null)
}