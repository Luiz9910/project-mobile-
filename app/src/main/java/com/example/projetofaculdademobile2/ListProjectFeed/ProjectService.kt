package com.example.projetofaculdademobile2.ListProjectFeed

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ProjectService {
    @GET("project/{user}")
    fun listProject(@Path("user") user: String?): Call<List<ProjectModel>>

    @GET("project/projects")
    fun listSearchProject(@Query("title") title: String?): Call<List<ProjectModel>>

    @POST("project")
    fun postProject(@Body ProjectModel: com.example.projetofaculdademobile2.Model.ProjectModel): Call<ResponseBody>
}