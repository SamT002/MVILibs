package com.example.coffeeshopapplication.common

import android.app.Application
import com.example.coffeeshopapplication.orbit.di.MoneyModule
import org.koin.core.context.startKoin

class CoffeeAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(MoneyModule.create())
        }
    }
}