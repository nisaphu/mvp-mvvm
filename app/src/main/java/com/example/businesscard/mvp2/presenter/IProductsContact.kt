package com.example.businesscard.mvp2.presenter

import com.example.businesscard.mvp2.model.ProductsDetail

interface IProductsContact {

    interface IProductsPresenter {
        fun loadDateApi()
    }

   /* interface IProductsView {
        fun setProductList(productDetailList: ArrayList<ProductsDetail>)
        fun showAlert(msg : String)
        fun showProgress()
        fun hideProgress()
    }*/
}