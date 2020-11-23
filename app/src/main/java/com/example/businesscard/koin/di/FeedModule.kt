package com.example.businesscard.koin.di

import com.example.businesscard.koin.repository.NewsRepository
import com.example.businesscard.koin.repository.NewsRepositoryImpl
import com.example.businesscard.koin.viewmodel.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val feedModule = module {

//    factory<NewsRepository> {NewsRepositoryImpl(get())}
    single { NewsRepositoryImpl(get()) }
    viewModel { FeedViewModel(get()) }
}