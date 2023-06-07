package com.example.projetofaculdademobile2.Service

import com.example.projetofaculdademobile2.Model.CommentModel
import retrofit2.Call
import retrofit2.http.*

interface CommentService {
    @GET("comment/comments")
    fun listComment(s: String): Call<List<CommentModel>>
}