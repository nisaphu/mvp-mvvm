package com.example.businesscard.mvp2.service

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServices {

    private lateinit var iGetServices: IGetServices

    fun createService() : IGetServices{
        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.github.com/")
            .build()
        iGetServices = retrofit.create(IGetServices::class.java)

        return iGetServices
    }
}