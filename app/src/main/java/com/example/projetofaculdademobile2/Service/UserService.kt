package com.example.projetofaculdademobile2.Service

import com.example.projetofaculdademobile2.Model.ProjectModel
import com.example.projetofaculdademobile2.Model.UserModel
import com.example.projetofaculdademobile2.Model.UserProfile
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserService {
    @POST("user/user")
    fun createUser(@Body userModel: UserModel): Call<ResponseBody>

    @PUT("user/{id}")
<<<<<<< HEAD
    fun updateUser(@Path("id") userId: Long, @Body userData: UserProfile): Call<ResponseBody>
=======
    fun updateUser(@Path("id") userId: Long, @Body userData: UserModel): Call<ResponseBody>

    @POST("user/user")
    fun createProject(@Body projectModel: ProjectModel): Call<ResponseBody>
>>>>>>> 4d36b620d3f7f14ad9057b594afbb34d43d24db2
}

