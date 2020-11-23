package com.example.businesscard.koin.data

import com.example.businesscard.koin.model.Article
import com.example.businesscard.koin.model.NewsDataModel
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("top-headlines?sources=abc-news&apiKey=c062f29ec2c54063a590d68cfc95d042")
    fun getFeed(): Observable<List<Article>>
}