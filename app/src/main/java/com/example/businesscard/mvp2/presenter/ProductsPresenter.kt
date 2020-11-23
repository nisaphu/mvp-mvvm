package com.example.businesscard.mvp2.presenter

import android.util.Log
import com.example.businesscard.mvp2.model.Products
import com.example.businesscard.mvp2.service.ApiServices
import com.example.businesscard.mvp2.view.IProductsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsPresenter(private val productView: IProductsView) :
    IProductsPresenter {

    private var apiService = ApiServices()

    override fun loadDateApi() {
//        productView.showProgress()

        apiService.createService().getAllProduct("dream").enqueue(object : Callback<Products> {
            override fun onFailure(call: Call<Products>, t: Throwable) {
//                productView.hideProgress()
//                productView.showAlert(t.message.toString())
            }

            override fun onResponse(call: Call<Products>, response: Response<Products>) {
//                Log.e("ProductsPresenter", "onResponse : " + response.body());
//                productView.hideProgress()
                productView.setProductList(response.body()!!.productDetailList);
            }
        })
    }
}