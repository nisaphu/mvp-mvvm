package com.example.businesscard.mvvm1.service

import com.example.businesscard.mvvm1.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IGetService {

//    @GET("products")
//    fun getAllProduct(@Query("page") per_page: Int): Call<Product>

    @GET("search/users")
    fun getAllProduct(@Query("q") q: String?): Call<Product>
}