package com.ttms.myapplication

    data class ApiResponse(
        val copyright: String,
        val numResults: Int,
        val results: ArrayList<Article>,
        val status: String
)