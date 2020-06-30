package com.github.udioshi85.cleanarchitecture.recycling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.udioshi85.cleanarchitecture.model.Loading
import java.lang.Exception
import java.lang.IllegalStateException

class MultipleTypesAdapter(var items: ArrayList<AdapterDataType>, private val typeFactory: TypeFactory) : RecyclerView.Adapter<BaseViewHolder<AdapterDataType>>() {

    val commonData: Bundle? = typeFactory.getCommonData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<AdapterDataType> {
        val layoutInflater = LayoutInflater.from(parent.context)
        return typeFactory.onCreateViewHolder(layoutInflater, parent, viewType) as BaseViewHolder<AdapterDataType>
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: BaseViewHolder<AdapterDataType>, position: Int) {
        // Leave empty
    }

    override fun onBindViewHolder(holder: BaseViewHolder<AdapterDataType>, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        holder.onBindViewHolder(items[position], commonData, payloads)
    }

    override fun getItemViewType(position: Int): Int {
        return try {
            items[position].type(typeFactory)

        } catch (e: Exception) {
            throw IllegalStateException("Cannot handle type in position=$position")
        }
    }

    fun setNewItems(newItems: ArrayList<AdapterDataType>) {
        val diffResult = DiffUtil.calculateDiff(MultiTypesDiffCallback(items, newItems))
        diffResult.dispatchUpdatesTo(this)

        items.clear()
        items.addAll(newItems)
    }

    fun addNewItems(newItems: ArrayList<AdapterDataType>) {
        val startPosition = itemCount
        items.addAll(newItems)
        notifyItemRangeInserted(startPosition, items.size)
    }

    fun addLoadingItem(item: AdapterDataType) {
        val position = itemCount
        this.items.add(item)
        notifyItemInserted(position)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }
}