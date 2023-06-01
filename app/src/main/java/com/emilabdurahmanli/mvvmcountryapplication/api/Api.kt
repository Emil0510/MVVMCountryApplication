package com.emilabdurahmanli.mvvmcountryapplication.api

import com.emilabdurahmanli.mvvmcountryapplication.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("{zipcode}")
    fun getCountry(@Path("zipcode") zipcode : Int) : Call<Result>

}