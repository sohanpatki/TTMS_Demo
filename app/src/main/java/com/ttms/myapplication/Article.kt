package com.ttms.myapplication

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("published_date")
    val publishedDate: String,
    @SerializedName("title")
    val title: String,
)