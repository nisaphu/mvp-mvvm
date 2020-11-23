package com.example.businesscard.mvp.presenter

import com.example.businesscard.mvp.model.UserResponse
import com.example.businesscard.mvp.service.GithubAPI
import com.example.businesscard.mvp.view.MainView
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainPresenter(private val view:MainView) {

        val retrofit:Retrofit =Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        fun searchUser(q:String?){
            retrofit.create(GithubAPI::class.java)
                .searchUsers(q)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<UserResponse> {
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: UserResponse) {
                        view.setAdapter(t.users)
                    }

                    override fun onError(e: Throwable) {
                    }
                })
        }
}