package com.example.projetofaculdademobile2.Model

data class CommentModel(
    var id: Long,
    var response: String,
    var userid: String?,
    var publicationid: String
)