package com.example.businesscard.mvp2.view

import com.example.businesscard.mvp2.model.ProductsDetail


interface IProductsView {
    fun setProductList(productDetailList: ArrayList<ProductsDetail>)
}