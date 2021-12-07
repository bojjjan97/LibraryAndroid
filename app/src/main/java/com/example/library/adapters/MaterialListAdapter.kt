package com.example.library.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.library.R
import com.example.library.models.Material

class MaterialListAdapter(private val materials: ArrayList<Material>) : Adapter<MaterialListAdapter.MaterialViewHolder>() {

    class MaterialViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val materialTitleTextView: TextView = view.findViewById(R.id.materialTitle)
        val materialAuthorsTextView: TextView = view.findViewById(R.id.materialAuthors)
        val materialImage: ImageView = view.findViewById(R.id.materialImage)
        val addToReservationButton: Button = view.findViewById(R.id.btnAddToReservation)

        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.material_layout, parent, false)

        return MaterialViewHolder(view)
    }

    override fun onBindViewHolder(holder: MaterialViewHolder, position: Int) {
        val material = materials[position]
        val imageUrl = holder.itemView.context.getString(R.string.server_url) + material.image.photoUrl

        holder.materialTitleTextView.text = material.title
        Glide.with(holder.materialImage.context).load(imageUrl).into(holder.materialImage)
        holder.materialAuthorsTextView.text = material.authors.joinToString(", ") { author -> author.firstname + " " + author.lastname }
        holder.addToReservationButton.setOnClickListener() {
            it.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int {
        return materials.size
    }
}