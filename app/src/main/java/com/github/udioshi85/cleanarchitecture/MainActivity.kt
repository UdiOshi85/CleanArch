package com.github.udioshi85.cleanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.udioshi85.cleanarchitecture.databinding.ActivityMainBinding
import com.github.udioshi85.cleanarchitecture.network.RetrofitManager
import com.github.udioshi85.cleanarchitecture.viewmodel.AlphaVantageViewModel
import com.github.udioshi85.cleanarchitecture.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity(), Observer<Resource<Any>> {

    private lateinit var binding: ActivityMainBinding
    private lateinit var alphaVantageViewModel: AlphaVantageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        alphaVantageViewModel = ViewModelProvider(this, ViewModelFactory(RetrofitManager.alphaVantageService)).get(AlphaVantageViewModel::class.java)

        // Observing the main live data object
        alphaVantageViewModel.mainLiveData.observe(this, this)

        binding.chain.setOnClickListener {
            alphaVantageViewModel.chainRequests()
        }

        binding.paraller.setOnClickListener {
            alphaVantageViewModel.parallelRequest()
        }
    }

    override fun onChanged(t: Resource<Any>?) {

    }
}
