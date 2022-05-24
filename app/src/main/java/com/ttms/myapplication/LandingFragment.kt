package com.ttms.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.ttms.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LandingFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchLayout.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.viewedLayout.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("ARTICLE_TYPE", ArticleType.VIEWED)
            findNavController().navigate(R.id.action_FirstFragment_to_ListFragment, bundle)
        }
        binding.sharedLayout.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("ARTICLE_TYPE", ArticleType.SHARED)
            findNavController().navigate(R.id.action_FirstFragment_to_ListFragment, bundle)
        }

        binding.emailedLayout.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("ARTICLE_TYPE", ArticleType.EMAILED)
            findNavController().navigate(R.id.action_FirstFragment_to_ListFragment, bundle)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}