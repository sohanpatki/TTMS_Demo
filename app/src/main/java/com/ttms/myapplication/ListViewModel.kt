package com.ttms.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ttms.myapplication.repository.ArticlesRepository

class ListViewModel : ViewModel() {
    var articles: MutableLiveData<ArrayList<Article>>? = MutableLiveData<ArrayList<Article>>()

    fun fetchArticles(type: ArticleType, topic: String = " ") {
        if (type == ArticleType.SEARCHED) {
            articles?.postValue(ArticlesRepository.getSearchedArticles(topic).value)
        } else {
            articles?.postValue(ArticlesRepository.getArticles(type).value)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("ListViewModel ", "Cleared")
    }
}