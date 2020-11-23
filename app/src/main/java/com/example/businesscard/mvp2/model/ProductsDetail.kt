package com.example.businesscard.mvp2.model

import com.google.gson.annotations.SerializedName

data class ProductsDetail(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("url") val url: String
)