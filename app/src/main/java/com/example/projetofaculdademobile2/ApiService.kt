package com.example.projetofaculdademobile2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("user/{user}")
    fun listRepos(@Path("user") user: String?): Call<List<Repositorio>>


}