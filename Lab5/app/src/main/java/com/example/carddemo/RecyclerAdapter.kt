package com.example.carddemo


import android.icu.number.NumberFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carddemo.services.dto.TechTalkDto
import com.squareup.picasso.Picasso

class RecyclerAdapter(val results: List<TechTalkDto>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.imageView)
            itemTitle = itemView.findViewById(R.id.avartar_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_row, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val techTalkDto = results?.get(position)
        holder.itemTitle.text = techTalkDto?.name
        Picasso.get().load(techTalkDto?.urlImage).into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return results.size
    }




}