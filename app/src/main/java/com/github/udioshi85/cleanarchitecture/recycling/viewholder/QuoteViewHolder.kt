package com.github.udioshi85.cleanarchitecture.recycling.viewholder

import android.os.Bundle
import com.github.udioshi85.cleanarchitecture.databinding.ViewHolderQuoteBinding
import com.github.udioshi85.cleanarchitecture.model.Quote
import com.github.udioshi85.cleanarchitecture.recycling.BaseViewHolder

class QuoteViewHolder(private val binding: ViewHolderQuoteBinding): BaseViewHolder<Quote>(binding.root) {

    override fun onBindViewHolder(data: Quote, commonData: Bundle?, payloads: MutableList<Any>?) {
        binding.quoteText.text = data.quoteText
        binding.quoteAuthor.text = data.quoteAuthor
    }
}