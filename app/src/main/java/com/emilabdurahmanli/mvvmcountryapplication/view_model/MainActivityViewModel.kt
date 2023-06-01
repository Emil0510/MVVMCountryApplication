package com.emilabdurahmanli.mvvmcountryapplication.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emilabdurahmanli.mvvmcountryapplication.model.Result
import com.emilabdurahmanli.mvvmcountryapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var result = MutableLiveData<Result>()

    fun getCountry(zipcode : Int){
        val call = RetrofitClient.getRetrofitInstance()?.getApi()?.getCountry(zipcode)
        call?.enqueue(object : Callback<Result>{
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                val result = response.body()
                this@MainActivityViewModel.result.postValue(result)
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {

            }

        })
    }

    fun observeResult() : LiveData<Result>{
        return result
    }


}