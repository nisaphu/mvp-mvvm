package com.example.businesscard.mvp.model

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("url") val url: String
)