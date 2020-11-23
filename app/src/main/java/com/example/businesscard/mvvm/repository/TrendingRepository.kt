package com.example.businesscard.mvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.businesscard.GiphyApplication
import com.example.businesscard.mvvm.data.database.DataEntity
import com.example.businesscard.mvvm.data.database.toDataEntityList
import com.example.businesscard.mvvm.data.database.toDataList
import com.example.businesscard.mvvm.data.network.GiphyApi
import com.example.businesscard.mvvm.di.DaggerAppComponent
import com.example.businesscard.mvvm.internal.KEY
import com.example.businesscard.mvvm.internal.LIMIT
import com.example.businesscard.mvvm.internal.RATING
import com.example.businesscard.mvvm.model.Data
import com.example.businesscard.mvvm.model.TrendingResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject

class TrendingRepository {
    @Inject
    lateinit var giphyApiService: GiphyApi

    @Inject
    lateinit var stringList : ArrayList<String>

    private val _data by lazy { MutableLiveData<List<Data>>() }
    val data: LiveData<List<Data>>
        get() = _data

    private val _isInProgress by lazy { MutableLiveData<Boolean>() }
    val isInProgress: LiveData<Boolean>
        get() = _isInProgress

    private val _isError by lazy {MutableLiveData<Boolean>()}
    val isError: LiveData<Boolean>
    get() = _isError

    init {
        DaggerAppComponent.create().inject(this)
    }

    private fun insertData(): Disposable{
        return giphyApiService.getTrending(KEY, LIMIT, RATING)
            .subscribeOn(Schedulers.io())
            .subscribeWith(subscribeToDatabase())
    }

    private fun subscribeToDatabase(): DisposableSubscriber<TrendingResult>{
        return object : DisposableSubscriber<TrendingResult>(){
            override fun onComplete() {
                Log.v("insertData", "insert success")
                getTrendingQuery()
            }

            override fun onNext(t: TrendingResult?) {
                if (t != null){
                    val entityList = t.data.toList().toDataEntityList()
                    GiphyApplication.database.apply {
                        dataDao().insertData(entityList)
                    }
                }
            }

            override fun onError(t: Throwable?) {
                _isInProgress.postValue(true)
                Log.e("insertData", "TrendingResult error: ${t?.message}")
                _isError.postValue(true)
                _isInProgress.postValue(false)
            }

        }
    }

    private fun getTrendingQuery(): Disposable{
        return GiphyApplication.database.dataDao()
            .queryData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {t: List<DataEntity>? ->
                    _isInProgress.postValue(true)
                    if (t != null && t.isNotEmpty()){
                        _isError.postValue(false)
                        _data.postValue(t.toDataList())
                    }else{
                        insertData()
                    }
                    _isInProgress.postValue(false)
                }, {
                    _isInProgress.postValue(true)
                    Log.e("getTrendingQuery", "Database error: ${it.message}")
                    _isError.postValue(true)
                    _isInProgress.postValue(false)
                }
            )
    }

    fun fetchDataFromDatabase(): Disposable = getTrendingQuery()
}