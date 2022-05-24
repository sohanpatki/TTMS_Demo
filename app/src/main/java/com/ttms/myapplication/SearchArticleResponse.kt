package com.ttms.myapplication

data class Response(
    val docs: ArrayList<Article>,
)

data class SearchResponse(
    val copyright: String,
    val response: Response,
    val status: String,
)