package com.example.carddemo.fragments

import TechTalkService
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carddemo.R
import com.example.carddemo.RecyclerAdapter
import com.example.carddemo.databinding.FragmentBlankBinding
import com.example.carddemo.services.dto.TechTalkDto
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private val BASE_URL: String = "http://4de23f4f50e3.ngrok.io"
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
        editor?.commit()
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

        val service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(TechTalkService::class.java)

        service.getTechTalks().enqueue(object : Callback<List<TechTalkDto>> {

            /* The HTTP call failed. This method is run on the main thread */
            override fun onFailure(call: Call<List<TechTalkDto>>, t: Throwable) {
                Log.d("TAG_", "An error happened!")

            }

            /* The HTTP call was successful, we should still check status code and response body
             * on a production app. This method is run on the main thread */
            override fun onResponse(
                call: Call<List<TechTalkDto>>,
                response: Response<List<TechTalkDto>>
            ) {
                /* This will print the response of the network call to the Logcat */
                Log.d("TAG_", response.body().toString())

                recyclerView.apply {
                    // set a LinearLayoutManager to handle Android
                    // RecyclerView behavior
                    layoutManager = LinearLayoutManager(activity)
                    // set the custom adapter to the RecyclerView
                    adapter = RecyclerAdapter(response.body().orEmpty())

                    recyclerView.layoutManager = layoutManager;
                    recyclerView.adapter = adapter

                }
            }
        })

        button.setOnClickListener { v -> findNavController().navigate(BlankFragmentDirections.actionBlankFragmentToSecondFragment()) };

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