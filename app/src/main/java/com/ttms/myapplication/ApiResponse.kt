package com.ttms.myapplication

    data class ApiResponse(
        val copyright: String,
        val num_results: Int,
        val results: ArrayList<Article>,
        val status: String
)