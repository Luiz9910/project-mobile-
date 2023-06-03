package com.example.projetofaculdademobile2.Service

import com.example.projetofaculdademobile2.Model.UserModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("user/user")
    fun createUser(@Body userModel: UserModel): Call<ResponseBody>
}
