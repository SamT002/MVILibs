package com.example.coffeeshopapplication.orbit.data.api

import com.example.coffeeshopapplication.orbit.data.model.Money
import retrofit2.http.GET

interface MoneyServiceApi {

    @GET("bpi/currentprice.json")
    fun fetchMoneys():Money

}