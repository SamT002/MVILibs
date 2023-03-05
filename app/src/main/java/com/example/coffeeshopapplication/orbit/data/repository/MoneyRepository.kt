package com.example.coffeeshopapplication.orbit.data.repository

import com.example.coffeeshopapplication.orbit.data.api.MoneyServiceApi
import com.example.coffeeshopapplication.orbit.data.model.Money

class MoneyRepository(private val moneyServiceApi: MoneyServiceApi) {

    fun fetchMoney(): Money {
        return moneyServiceApi.fetchMoneys()
    }

}