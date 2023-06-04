package com.example.projetofaculdademobile2.Service

import com.example.projetofaculdademobile2.Model.ProjectModelParcelize
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ProjectService {
    @GET("project/{user}")
    fun listProject(@Path("user") user: String?): Call<List<ProjectModelParcelize>>

    @GET("project/projects")
    fun listSearchProject(@Query("title") title: String?): Call<List<ProjectModelParcelize>>

    @POST("project")
    fun postProject(@Body ProjectModel: com.example.projetofaculdademobile2.Model.ProjectModel): Call<ResponseBody>
}