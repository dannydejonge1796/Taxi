package com.example.taxi.model

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.ListView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONObject

class RdwApi(private var context: Context)
{
  var url: String = "https://opendata.rdw.nl/resource/m9d7-ebf2.json"
  val gson: Gson = Gson()
  val queue: RequestQueue = Volley.newRequestQueue(context.applicationContext)
  var rdwArray = ArrayList<RDW>()

  fun getData(lv: ListView)
  {
    val stringRequest = StringRequest(
      Request.Method.GET,
      url,
      {response ->
//      Ophalen van de JSONobjecten
        val jarr = JSONArray(response)
        val arr = object: TypeToken<ArrayList<RDW>>() {}.type
        //Omzetten array van gson naar een Arraylist van eigen objecten
        rdwArray = gson.fromJson(jarr.toString(), arr)
        //Aanmaken ArrayAdapter (Noodzakelijke parameters, Context, stijl van de ListView, array met data
        val ad = ArrayAdapter(context, android.R.layout.simple_list_item_1, rdwArray)
        //Aangeven dat hij zelf de OnItemCLickListener is
//        lv.onItemClickListener = this
        lv.adapter = ad
      }, {

      })

    queue.add(stringRequest)
  }

//  override fun onItemClick(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
//    //Ophalen item uit de listview. parent? geeft aan dat hij null mag zijn, zonder te crashen
//    val rdw : RDW = parent?.getItemAtPosition(position) as RDW
//
//
////    //println(pokemon.name)
////    var intent = Intent(context, PokeDetails::class.java)
////    intent.putExtra("poke", pokemon)
////
////    context.startActivity(intent)
//
//
//  }
}