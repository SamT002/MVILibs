package com.example.coffeeshopapplication.orbit.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bpi(
    val EUR: EUR,
    val GBP: GBP,
    val USD: USD
):Parcelable