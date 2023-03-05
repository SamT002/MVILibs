package com.example.coffeeshopapplication.orbit.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Money(
    val bpi: Bpi,
    val chartName: String,
    val disclaimer: String,
    val time: Time
):Parcelable