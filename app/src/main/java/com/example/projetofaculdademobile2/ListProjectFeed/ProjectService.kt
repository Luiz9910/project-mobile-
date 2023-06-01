package com.example.projetofaculdademobile2.ListProjectFeed

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProjectService {
    @GET("project/{user}")
    fun listProject(@Path("user") user: String?): Call<List<ProjectModel>>

}