package com.github.udioshi85.cleanarchitecture.recycling.viewholder

import android.os.Bundle
import com.github.udioshi85.cleanarchitecture.databinding.ViewHolderLoadingBinding
import com.github.udioshi85.cleanarchitecture.model.Loading
import com.github.udioshi85.cleanarchitecture.recycling.BaseViewHolder

class LoadingViewHolder(val binding: ViewHolderLoadingBinding): BaseViewHolder<Loading>(binding.root) {
    override fun onBindViewHolder(data: Loading, commonData: Bundle?, payloads: MutableList<Any>?) {

    }
}