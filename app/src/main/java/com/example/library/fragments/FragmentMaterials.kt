package com.example.library.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.library.R
import com.example.library.adapters.MaterialListAdapter
import com.example.library.models.Material
import com.example.library.repositories.MaterialsRepository

class FragmentMaterials : Fragment() {
    val materials : ArrayList<Material> = ArrayList<Material>()
    lateinit var adapter : MaterialListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = MaterialListAdapter(materials)

        fetchMaterials()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_materials, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewMaterials)
        recyclerView.adapter = adapter
        context?.let { recyclerView.layoutManager = LinearLayoutManager(it) }


        return view
    }

    fun fetchMaterials() {
        getContext()?.let { MaterialsRepository.GetAllMaterials(it) {
            materials.clear()
            materials.addAll(it)
            Log.d("BOJAN", it[0].toString())
            adapter.notifyDataSetChanged()
        } }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentMaterials().apply {
                arguments = Bundle().apply { }
            }
    }
}