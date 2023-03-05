package com.example.coffeeshopapplication.orbit.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EUR(
    val code: String,
    val description: String,
    val rate: String,
    val rate_float: Double,
    val symbol: String
):Parcelable