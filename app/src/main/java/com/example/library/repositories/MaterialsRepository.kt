package com.example.library.repositories

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.library.R
import com.example.library.models.Material
import com.google.gson.Gson


object MaterialsRepository {
    fun GetAllMaterials(context: Context, onData: (Array<Material>) -> Unit){

        val queue = Volley.newRequestQueue(context)
        val url = context.getString(R.string.server_url) + "/api/Material"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                var gson = Gson()
                val result = gson.fromJson(response,  Array<Material>::class.java)
                onData(result)
            },
            Response.ErrorListener { e ->
                Log.d("BOJAN", e.message.toString())
            })

        queue.add(stringRequest)
    }
}