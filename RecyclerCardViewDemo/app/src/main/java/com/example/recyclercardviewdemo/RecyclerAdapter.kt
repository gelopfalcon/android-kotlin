package com.example.recyclercardviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val titles = arrayOf("Chapter One",
        "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight")


    private val images = intArrayOf(R.drawable.kotlin,
        R.drawable.kotlin, R.drawable.kotlin,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.imageView)
            itemTitle = itemView.findViewById(R.id.avartarName)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_row, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemImage.setImageResource(images[position])
        holder.itemTitle.text = titles[position]
    }

}