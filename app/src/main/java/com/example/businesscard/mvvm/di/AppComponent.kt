package com.example.businesscard.mvvm.di

import com.example.businesscard.mvvm.repository.TrendingRepository
import com.example.businesscard.mvvm.view.ui.Main2Activity
import com.example.businesscard.mvvm.viewmodel.TrendingViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(trendingRepository: TrendingRepository)

    fun inject(viewModel: TrendingViewModel)

    fun inject(mainActivity: Main2Activity)
}