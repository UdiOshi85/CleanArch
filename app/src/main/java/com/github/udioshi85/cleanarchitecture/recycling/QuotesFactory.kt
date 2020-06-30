package com.github.udioshi85.cleanarchitecture.recycling

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.udioshi85.cleanarchitecture.R
import com.github.udioshi85.cleanarchitecture.databinding.ViewHolderLoadingBinding
import com.github.udioshi85.cleanarchitecture.databinding.ViewHolderQuoteBinding
import com.github.udioshi85.cleanarchitecture.model.Loading
import com.github.udioshi85.cleanarchitecture.model.Quote
import com.github.udioshi85.cleanarchitecture.recycling.viewholder.LoadingViewHolder
import com.github.udioshi85.cleanarchitecture.recycling.viewholder.QuoteViewHolder

class QuotesFactory: BaseFactory() {

    override fun type(quote: Quote): Int = R.layout.view_holder_quote
    override fun type(loading: Loading): Int = R.layout.view_holder_loading



    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, type: Int): BaseViewHolder<*>? {
        return when(type) {
            R.layout.view_holder_quote -> {
                QuoteViewHolder(ViewHolderQuoteBinding.inflate(inflater, parent, false))
            }

            R.layout.view_holder_loading -> {
                LoadingViewHolder(ViewHolderLoadingBinding.inflate(inflater, parent, false))
            }

            else -> super.onCreateViewHolder(inflater, parent, type)
        }
    }
}