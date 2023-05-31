package com.example.projetofaculdademobile2.ListProjectFeed

import com.example.projetofaculdademobile2.ListProjectFeed.ListProjectFeed.ProjectModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProjectService {

    @GET("user/{user}")
    fun listRepos(@Path("user") user: String?): Call<List<ProjectModel>>


}