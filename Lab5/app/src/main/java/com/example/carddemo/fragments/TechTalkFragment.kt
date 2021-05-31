package com.example.carddemo.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carddemo.R
import com.example.carddemo.RecyclerAdapter
import com.example.carddemo.databinding.FragmentBlankBinding
import com.example.carddemo.viewmodels.TechTalkViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [TechTalkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TechTalkFragment : Fragment() {

    private val model: TechTalkViewModel by viewModels()
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private var sharedPreferences: SharedPreferences? = null
    private var _binding: FragmentBlankBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView. !
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("fragments", "onCreate")

        sharedPreferences = activity?.getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE)

        var editor = sharedPreferences?.edit()
        editor?.putString("username", "gelopfalcon")
        editor?.apply()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("fragments", "onCreateView")
        // Inflate the layout for this fragment
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("fragments", "onViewCreated")

        var recyclerView = binding.recyclerView
        var button: Button = view.findViewById(R.id.button2)

        model.getTechTalks()
        model.techTalksLiveData.observe(viewLifecycleOwner, Observer {
            /* This will print the response of the network call to the Logcat */
            Log.d("TAG_", it.toString())

            recyclerView.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = LinearLayoutManager(activity)
                // set the custom adapter to the RecyclerView
                adapter = RecyclerAdapter(it)

                recyclerView.layoutManager = layoutManager;
                recyclerView.adapter = adapter

            }
        })


        button.setOnClickListener { v -> findNavController().navigate(TechTalkFragmentDirections.actionBlankFragmentToSecondFragment()) };

    }

    override fun onStop() {
        super.onStop()
        Log.i("fragments", "onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.i("fragments", "onResume")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.i("fragments", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("fragments", "onDestroy")
    }
}