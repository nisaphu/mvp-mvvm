package com.example.businesscard.mvvm1.model

import com.google.gson.annotations.SerializedName

data class Product(
    var status: Int = 0,
    var message: String = "",
    @SerializedName("items") var productDetailList: ArrayList<ProductDetail> = arrayListOf()
)