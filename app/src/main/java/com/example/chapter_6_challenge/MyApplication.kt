package com.example.chapter_6_challenge

import android.app.Application
import com.example.chapter_6_challenge.di.viewModelModule
import com.example.di.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(koinModule, viewModelModule)
        }
    }
}