package com.example.projetofaculdademobile2.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProjectModelParcelize(
    val id: Int,
    val title: String,
    val body: String
) : Parcelable