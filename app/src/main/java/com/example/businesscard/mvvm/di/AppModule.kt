package com.example.businesscard.mvvm.di

import com.example.businesscard.mvvm.data.network.GiphyApi
import com.example.businesscard.mvvm.data.network.GiphyApiService
import com.example.businesscard.mvvm.model.Data
import com.example.businesscard.mvvm.repository.TrendingRepository
import com.example.businesscard.mvvm.view.adapter.TrendingAdapter
import com.example.businesscard.mvvm.viewmodel.TrendingViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApi(): GiphyApi = GiphyApiService.getClient()

    @Provides
    fun provideTrendingRepository() = TrendingRepository()

    @Provides
    fun provideListData() = ArrayList<Data>()

    @Provides
    fun provideListString() = ArrayList<String>()

    @Provides
    fun provideTrendingAdapter(data: ArrayList<Data>): TrendingAdapter = TrendingAdapter(data)

}