package com.example.projetofaculdademobile2.ListProjectFeed

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProjectService {
    @GET("project/{user}")
    fun listProject(@Path("user") user: String?): Call<List<ProjectModel>>

    @GET("project/projects")
    fun listSearchProject(@Query("title") title: String?): Call<List<ProjectModel>>
}