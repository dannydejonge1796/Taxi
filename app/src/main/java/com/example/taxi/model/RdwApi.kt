package com.example.taxi.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray

class RdwApi(private var context: Context)
{
  var url: String = "https://opendata.rdw.nl/resource/m9d7-ebf2.json"
  val gson: Gson = Gson()
  val queue: RequestQueue = Volley.newRequestQueue(context.applicationContext)
  var rdwArray = ArrayList<RDW>()

  fun getData(lv: ListView) {
    val stringRequest = StringRequest(
      Request.Method.GET,
      url,
      { response ->
        // Ophalen van de JSONobjecten
        val jarr = JSONArray(response)
        val arr = object : TypeToken<ArrayList<RDW>>() {}.type
        // Omzetten array van gson naar een Arraylist van eigen objecten
        val rdwArray = gson.fromJson<ArrayList<RDW>>(jarr.toString(), arr)
        // Define a custom layout for each list item
        val itemLayoutResId = android.R.layout.simple_list_item_2

        val ad = object : ArrayAdapter<RDW>(context, itemLayoutResId, rdwArray) {
          override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(itemLayoutResId, parent, false)
            val item = getItem(position)
            val kentekenTextView = view.findViewById<TextView>(android.R.id.text1)
            val voertuigsoortTextView = view.findViewById<TextView>(android.R.id.text2)
            kentekenTextView.text = item?.kenteken ?: ""
            voertuigsoortTextView.text = item?.voertuigsoort ?: ""
            return view
          }
        }
        lv.adapter = ad
      },
      {

      }
    )
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