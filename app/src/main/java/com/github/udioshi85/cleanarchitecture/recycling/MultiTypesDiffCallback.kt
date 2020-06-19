package com.github.udioshi85.cleanarchitecture.recycling

import androidx.recyclerview.widget.DiffUtil

class MultiTypesDiffCallback(private val oldList: ArrayList<AdapterDataType>, private val newList: List<AdapterDataType>): DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition] == newList[newItemPosition]

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition] == newList[newItemPosition]
}