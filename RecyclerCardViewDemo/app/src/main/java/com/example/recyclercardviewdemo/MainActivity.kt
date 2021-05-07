package com.example.recyclercardviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView: RecyclerView = this.findViewById(R.id.recyclerView);

        adapter = RecyclerAdapter()
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager;
        recyclerView.adapter = adapter
    }
}