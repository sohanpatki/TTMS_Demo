package com.ttms.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel

class SearchViewModel: ViewModel() {

    fun onSearchClicked(article: String) {
        Log.e("SearchViewModel ","onSearchClicked()" )
    }
}