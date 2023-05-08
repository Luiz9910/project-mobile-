package com.example.listview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String,
    val phone: String,
    val hobby: String? = null,
    val height: Double? = null,
    val weight: Double? = null
): Parcelable