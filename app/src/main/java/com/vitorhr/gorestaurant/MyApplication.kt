package com.vitorhr.gorestaurant

import android.app.Application
import com.vitorhr.gorestaurant.di.appModule
import com.vitorhr.gorestaurant.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(appModule, viewModelModule)
        }
    }
}