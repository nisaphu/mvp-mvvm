package com.example.businesscard

import android.app.Application
import com.example.businesscard.koin.di.feedModule
import com.example.businesscard.koin.di.networkModule
import com.example.businesscard.mvvm.data.database.TrendingDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GiphyApplication : Application() {

    companion object{
        lateinit var instance: GiphyApplication
        lateinit var database: TrendingDatabase
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        database = TrendingDatabase.invoke(this)
//        startKoin{ androidContext(this@GiphyApplication)
//                modules(networkModule, feedModule)
//        }
    }
}