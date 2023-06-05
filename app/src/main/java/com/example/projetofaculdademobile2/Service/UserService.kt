package com.example.projetofaculdademobile2.Service

import com.example.projetofaculdademobile2.Model.LoginRequest
import com.example.projetofaculdademobile2.Model.LoginResponse
import com.example.projetofaculdademobile2.Model.UserModel
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
    fun updateUser(@Path("id") userId: Long, @Body userData: UserModel): Call<ResponseBody>

    @POST("user/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
}

