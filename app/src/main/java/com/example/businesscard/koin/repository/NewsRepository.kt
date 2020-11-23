package com.example.businesscard.koin.repository

import com.example.businesscard.koin.data.Api
import com.example.businesscard.koin.model.Article
import io.reactivex.Observable

interface NewsRepository {
    fun getFeed(): Observable<List<Article>>
}

class NewsRepositoryImpl(private val api: Api): NewsRepository {

    override fun getFeed(): Observable<List<Article>> {
        return api.getFeed()
    }
}
