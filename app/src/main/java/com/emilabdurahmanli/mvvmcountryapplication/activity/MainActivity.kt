package com.emilabdurahmanli.mvvmcountryapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.emilabdurahmanli.mvvmcountryapplication.R
import com.emilabdurahmanli.mvvmcountryapplication.databinding.ActivityMainBinding
import com.emilabdurahmanli.mvvmcountryapplication.view_model.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.searchButton.setOnClickListener {
            if(binding.zipcodeET.text.toString() != "") {
                binding.progressBarCyclic.visibility = View.VISIBLE
                viewModel.getCountry(binding.zipcodeET.text.toString().toInt())
            }
        }

        viewModel.observeResult().observe(this, Observer {result ->
            binding.countryText.text = "Country: ${result.country}"
            binding.stateText.text = "Country: ${result.state}"
            binding.cityText.text = "Country: ${result.city}"
            binding.progressBarCyclic.visibility = View.GONE
        })
    }
}