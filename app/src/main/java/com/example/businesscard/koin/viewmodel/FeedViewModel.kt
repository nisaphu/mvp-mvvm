package com.example.businesscard.koin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.businesscard.koin.model.Article
import com.example.businesscard.koin.repository.NewsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FeedViewModel(private val repository: NewsRepository): ViewModel() {

    private var articleList = MutableLiveData<List<Article>>()
    private var errorMessage = MutableLiveData<String>()
    private val compositeDisposable = CompositeDisposable()

    fun articleList(): LiveData<List<Article>> = articleList
    fun errorMessage(): LiveData<String> = errorMessage

    fun getFeed(){
        val disposable = repository.getFeed()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ articles ->
                articleList.value = articles
            }, { error ->
                errorMessage.value = error.localizedMessage
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}