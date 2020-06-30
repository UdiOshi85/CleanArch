package com.github.udioshi85.cleanarchitecture

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.udioshi85.cleanarchitecture.databinding.ActivityMainBinding
import com.github.udioshi85.cleanarchitecture.model.Loading
import com.github.udioshi85.cleanarchitecture.recycling.AdapterDataType
import com.github.udioshi85.cleanarchitecture.recycling.MultipleTypesAdapter
import com.github.udioshi85.cleanarchitecture.recycling.QuotesFactory
import com.github.udioshi85.cleanarchitecture.ui.BaseActivity
import com.github.udioshi85.cleanarchitecture.viewmodel.QuoteGardenViewModel
import com.github.udioshi85.cleanarchitecture.viewmodel.ViewModelFactory
import com.github.udioshi85.tooly.EndlessScrollListener
import com.github.udioshi85.tooly.extentions.setGone
import com.github.udioshi85.tooly.extentions.setVisible

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var quoteGardenViewModel: QuoteGardenViewModel

    private var quotesAdapter: MultipleTypesAdapter? = null
    private val quotesFactory = QuotesFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        quoteGardenViewModel = ViewModelProvider(this, ViewModelFactory()).get(QuoteGardenViewModel::class.java)

        // Observing the main live data object
        quoteGardenViewModel.mainLiveData.observe(this, this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.quotesList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.quotesList.addOnScrollListener(object: EndlessScrollListener(1) {
            override fun isLastPage(): Boolean = quoteGardenViewModel.isLastPage

            override fun isLoading(): Boolean = quoteGardenViewModel.isLoading

            override fun onLoadMore(page: Int) {
                quoteGardenViewModel.loadQuotes(true, page)
            }
        })

        quoteGardenViewModel.loadQuotes(false, 1)
    }

    override fun onDataLoading(resource: Resource<Any>) {
        when (resource.actionType) {
            QuoteGardenViewModel.ACTION_LOAD_QUOTES_FIRST_PAGE -> binding.progress.setVisible()

            QuoteGardenViewModel.ACTION_LOAD_QUOTES_PAGINATION -> quotesAdapter?.addLoadingItem(Loading())
        }
    }

    override fun onDataError(resource: Resource<Any>) {
        when (resource.actionType) {
            QuoteGardenViewModel.ACTION_LOAD_QUOTES_FIRST_PAGE -> {
                binding.progress.setGone()
                // Show error view
            }

            QuoteGardenViewModel.ACTION_LOAD_QUOTES_PAGINATION -> {
                quotesAdapter?.let {
                    val loadingItemPosition = it.items.indexOfFirst { item -> item is Loading }
                    if (loadingItemPosition != -1) {
                        it.removeItem(loadingItemPosition)
                    }
                }

                // Show pagination error
            }
        }
    }

    override fun onDataFetched(resource: Resource<Any>) {
        when (resource.actionType) {
            QuoteGardenViewModel.ACTION_LOAD_QUOTES_FIRST_PAGE -> {
                quotesAdapter = MultipleTypesAdapter(resource.data as ArrayList<AdapterDataType>, quotesFactory)
                binding.quotesList.adapter = quotesAdapter
                binding.progress.setGone()
            }

            QuoteGardenViewModel.ACTION_LOAD_QUOTES_PAGINATION -> {
                quotesAdapter?.let {
                    val loadingItemPosition = it.items.indexOfFirst {item ->  item is Loading }
                    if (loadingItemPosition != -1) {
                        it.removeItem(loadingItemPosition)
                    }

                    it.addNewItems(resource.data as ArrayList<AdapterDataType>)
                }
            }
        }
    }
}
