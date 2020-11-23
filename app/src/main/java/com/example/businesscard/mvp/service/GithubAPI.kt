package com.example.businesscard.mvp.service

import com.example.businesscard.mvp.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubAPI {
    @GET("search/users")
    fun searchUsers(@Query("q") q: String?): Observable<UserResponse>
}