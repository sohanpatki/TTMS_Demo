package com.ttms.myapplication

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName(value = "published_date", alternate = ["pub_date"])
    val publishedDate: String,
    @SerializedName(value = "title", alternate = ["section_name"])
    val title: String,
)