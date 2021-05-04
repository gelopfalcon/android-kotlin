package com.example.carddemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carddemo.databinding.FragmentBlankBinding


/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    private var _binding: FragmentBlankBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView. !
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("fragments", "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

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


        recyclerView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = RecyclerAdapter()
            recyclerView.layoutManager = layoutManager;
            recyclerView.adapter = adapter

        }

        button.setOnClickListener { v -> findNavController().navigate(BlankFragmentDirections.actionBlankFragmentToSecondFragment())  };

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