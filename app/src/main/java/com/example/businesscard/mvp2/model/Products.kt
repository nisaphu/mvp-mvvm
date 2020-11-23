package com.example.businesscard.mvp2.model

import com.google.gson.annotations.SerializedName

data class Products(
    var status: Int = 0,
    var message: String = "",
    @SerializedName("items") var productDetailList: ArrayList<ProductsDetail> = arrayListOf()
)