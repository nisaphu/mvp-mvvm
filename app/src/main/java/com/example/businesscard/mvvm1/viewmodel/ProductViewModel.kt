package com.example.businesscard.mvvm1.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.businesscard.mvvm1.model.Product
import com.example.businesscard.mvvm1.service.ApiService
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {

    private var service: ApiService? = null
    private var productMutableLiveData: MutableLiveData<Product> = MutableLiveData<Product>()

    init {
        fetchDataProduct()
    }

    private fun fetchDataProduct() {
        service = ApiService()
        service!!.createService().getAllProduct("dream")
            .enqueue(object : Callback<Product> {
                override fun onResponse(call: Call<Product>, response: Response<Product>) {
                    Observable.just(response.body())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subscribeData())
                }

                override fun onFailure(call: Call<Product>, t: Throwable) {

                }
            })
    }

    private fun subscribeData(): Observer<Product?> {
        return object : Observer<Product?> {
            override fun onSubscribe(d: Disposable) {}
            override fun onNext(t: Product) {
                productMutableLiveData.value = t
                Log.d("TAG", "onNext: $t")
            }

            override fun onError(e: Throwable) {
                Log.d("TAG", "onError: $e")
            }
            override fun onComplete() {
                Log.d("TAG", "onComplete: onComplete")
            }
        }
    }

    fun getProductList(): MutableLiveData<Product> {
        return productMutableLiveData
    }
}
