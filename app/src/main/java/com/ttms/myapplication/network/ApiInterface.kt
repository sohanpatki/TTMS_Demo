package com.ttms.myapplication.network

import com.ttms.myapplication.ApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("viewed/{period}.json")
    fun getViewedArticles(@Path("period") period: Int, @Query("api-key")token: String): Call<ApiResponse>

    @GET("shared/{period}.json")
    fun getSharedArticles(@Path("period") period: Int, @Query("api-key")token: String): Call<ApiResponse>

    @GET("emailed/{period}.json")
    fun getEmailedArticles(@Path("period") period: Int, @Query("api-key")token: String): Call<ApiResponse>
}