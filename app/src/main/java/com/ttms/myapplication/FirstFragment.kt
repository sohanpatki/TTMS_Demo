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
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "NYT"

        binding.searchLayout.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.viewedLayout.setOnClickListener {
            Toast.makeText(context, "Most Viewed", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_FirstFragment_to_ListFragment)
        }

        binding.sharedLayout.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_ListFragment)
        }

        binding.emailedLayout.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_ListFragment)
            //findNavController().setGraph(id.ac, Bundle())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}