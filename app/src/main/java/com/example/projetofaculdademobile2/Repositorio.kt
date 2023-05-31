package com.example.projetofaculdademobile2

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Repositorio(
    val id: Int,
    val name: String,
    val description: String
) : Parcelable