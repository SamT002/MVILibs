package com.example.coffeeshopapplication.orbit.di

import androidx.lifecycle.SavedStateHandle
import com.example.coffeeshopapplication.orbit.features.viewModel.MoneyViewModel
import com.example.coffeeshopapplication.orbit.data.api.MoneyServiceApi
import com.example.coffeeshopapplication.orbit.data.repository.MoneyRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object MoneyModule {

    fun create() = module{
        single {
            Retrofit.Builder()
                .baseUrl("https://api.coindesk.com/v1")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }

        single { createMoneyApiService(get()) }
        single { MoneyRepository(get()) }

        viewModel { (handle: SavedStateHandle) -> MoneyViewModel(handle, get()) }

    }

    private fun createMoneyApiService(retrofit: Retrofit): MoneyServiceApi {
        return retrofit.create(MoneyServiceApi::class.java)
    }

}