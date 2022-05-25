package com.ttms.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ttms.myapplication.databinding.FragmentListBinding
import java.util.ArrayList

class ListFragment : Fragment() {
    private lateinit var model: ListViewModel
    private var _binding: FragmentListBinding? = null
    private var articlesAdapter: ArticlesAdapter = ArticlesAdapter(ArrayList<Article>())

    private var artType: ArticleType? = null
    private lateinit var topic: String

    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            artType = it.getSerializable("ARTICLE_TYPE") as ArticleType?
            topic = it.getString("topic", "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        model = ViewModelProvider(this)[ListViewModel::class.java]
        model.articles
            ?.observe(viewLifecycleOwner, Observer<java.util.ArrayList<Article>> { list ->
                //set data in UI
                binding.progressBar.visibility = View.GONE
                if (list != null) {
                    Toast.makeText(context,
                        "received records = " + list.size.toString(),
                        Toast.LENGTH_SHORT)
                        .show()
                    articlesAdapter.setAdapter(list)

                } else {
                    Toast.makeText(context, "No records received", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            this.adapter = articlesAdapter
        }
        binding.click.setOnClickListener(View.OnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            artType?.let { it1 -> model.fetchArticles(it1, topic) }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("ListFragment", "onDestroyView()")
        //model.articles?.value = ArrayList<Article>()
    }
}