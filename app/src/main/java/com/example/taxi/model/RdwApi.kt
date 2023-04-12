package com.example.taxi.model

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class RdwApi(context: Context)
{
  var url: String = "https://opendata.rdw.nl/resource/m9d7-ebf2.json"
  val gson: Gson = Gson()
  val queue: RequestQueue = Volley.newRequestQueue(context.applicationContext)

  fun getData()
  {
    val stringRequest = StringRequest(
      Request.Method.GET,
      url,
      {response ->
        println(response.toString())
      }, {

      })

    queue.add(stringRequest)
  }
}