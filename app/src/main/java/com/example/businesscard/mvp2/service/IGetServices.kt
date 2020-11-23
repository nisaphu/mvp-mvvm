package com.example.businesscard.mvp2.service

import com.example.businesscard.mvp2.model.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IGetServices {

    @GET("search/users")
    fun getAllProduct(@Query("q") q: String?): Call<Products>
}