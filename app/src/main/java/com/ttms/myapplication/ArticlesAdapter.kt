package com.ttms.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticlesAdapter(var list: List<Article>) : RecyclerView.Adapter<ArticlesViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setAdapter(list: List<Article>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ArticlesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        return holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView = itemView.findViewById(R.id.tv_title)
    private val date: TextView = itemView.findViewById(R.id.tv_date)
    fun bind(article: Article) {
        title.text = article.title
        date.text = article.publishedDate
    }
}