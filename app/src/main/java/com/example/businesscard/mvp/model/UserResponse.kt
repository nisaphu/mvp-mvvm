package com.example.businesscard.mvp.model

import com.google.gson.annotations.SerializedName

class UserResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_result") val incompleteResult: Boolean,
    @SerializedName("items") val users: List<User>
)