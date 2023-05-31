package com.example.projetofaculdademobile2.ListProjectFeed

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProjectModel(
    val id: Int,
    val name: String,
    val description: String
) : Parcelable