package com.example.projetofaculdademobile2.Service

import com.example.projetofaculdademobile2.Model.ProjectModel
import com.example.projetofaculdademobile2.Model.ProjectModelParcelize
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ProjectService {
    @GET("project/{project}")
    fun listProject(@Path("project") project: String?): Call<List<ProjectModelParcelize>>

    @GET("project/projects")
    fun listSearchProject(@Query("title") title: String?): Call<List<ProjectModelParcelize>>

    @POST("project")
    fun postProject(@Body ProjectModel: ProjectModel): Call<ResponseBody>

    @DELETE("project/{projectId}")
    fun deleteProject(@Path("projectId") projectId: String): Call<ResponseBody>

    @PUT("project/{projectId}")
    fun updateProject(
        @Path("projectId") projectId: String?,
        @Body updatedProject: ProjectModel
    ): Call<ProjectModel>

}