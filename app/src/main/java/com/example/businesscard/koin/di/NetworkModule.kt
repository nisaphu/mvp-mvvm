package com.example.businesscard.koin.di

import com.example.businesscard.koin.data.Api
import com.example.businesscard.koin.data.OkHttpBuilder
import com.example.businesscard.koin.data.RetrofitBuilder
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https//newsapi.org/v2/"

val networkModule = module {
    single { OkHttpBuilder().build() }

    single<CallAdapter.Factory> { RxJava2CallAdapterFactory.create() }

    single<Converter.Factory> { GsonConverterFactory.create() }

    single { RetrofitBuilder(get(), get(), get()) }

    single<Api> { get<RetrofitBuilder>().build(BASE_URL) }
}