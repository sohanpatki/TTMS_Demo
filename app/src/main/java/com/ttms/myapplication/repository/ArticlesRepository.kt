package com.ttms.myapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ttms.myapplication.ApiResponse
import com.ttms.myapplication.Article
import com.ttms.myapplication.ArticleType
import com.ttms.myapplication.SearchResponse
import com.ttms.myapplication.network.ApiInterface
import com.ttms.myapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesRepository {
    companion object {
        private const val token = "YYmp5fBpHA2PHevNJAFsfiaqUy4ad2UD"
        var listLiveData: MutableLiveData<ArrayList<Article>> =
            MutableLiveData<ArrayList<Article>>()

        fun getArticles(type: ArticleType): LiveData<ArrayList<Article>> {
            val apiInterface = RetrofitClient.getInstance()
                .create(ApiInterface::class.java)//ApiInterface.getApiInterface()
            var call: Call<ApiResponse>? = null
            call = when (type) {
                ArticleType.VIEWED -> apiInterface.getViewedArticles(7,
                    token)
                ArticleType.SHARED -> apiInterface.getSharedArticles(7,
                    token)
                ArticleType.EMAILED -> apiInterface.getEmailedArticles(7,
                    token)
                ArticleType.SEARCHED -> TODO()
            }

            call?.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        listLiveData.postValue(response.body()?.results)
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.e("ArticlesRepository", "callback failed!")
                }

            })
            return listLiveData
        }

        fun getSearchedArticles(searchTopic: String = ""): LiveData<ArrayList<Article>> {
            val apiInterface = RetrofitClient.getInstance()
                .create(ApiInterface::class.java)//ApiInterface.getApiInterface()
            var call: Call<SearchResponse>? = null
            call = apiInterface.getSearchedArticles(searchTopic, token)

            call.enqueue(object : Callback<SearchResponse> {
                override fun onResponse(
                    call: Call<SearchResponse>,
                    response: Response<SearchResponse>,
                ) {
                    if (response.isSuccessful) {
                        listLiveData.postValue(response.body()?.response?.docs)
                    }
                }

                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    Log.e("ArticlesRepository", "getSearchedArticles::callback failed!")
                }


            })
            return listLiveData
        }
    }
}