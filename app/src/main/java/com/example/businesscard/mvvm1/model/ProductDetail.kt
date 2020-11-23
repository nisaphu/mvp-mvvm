package com.example.businesscard.mvvm1.model

import com.google.gson.annotations.SerializedName

data class ProductDetail(
//    var id: Int = 0,
//    var is_dead: Boolean,
//    var name: String,
//    var tags: String,
//    var origin: String,
//    var varietal: String,
//    var style: String,
//    @SerializedName("price_in_cents") var priceInCents: Int = 0,
//    @SerializedName("regular_price_in_cents") var regularPriceInCents: Int = 0,
//    @SerializedName("stock_type") var stockType: String,
//    @SerializedName("primary_category") var primaryCategory: String,
//    @SerializedName("secondary_category") var secondaryCategory: String,
//    @SerializedName("alcohol_content") var alcoholContent: String,
//    @SerializedName("image_thumb_url") var imageThumbUrl:String,
//    @SerializedName("image_url") var imageUrl:String,
//    @SerializedName("product_no") var productNo:Int
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("url") val url: String
)