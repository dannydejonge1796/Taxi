package com.example.taxi.model

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.taxi.view.DetailActivity
import com.example.taxi.view.HomeActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray

class RdwApi(private var context: HomeActivity) : AdapterView.OnItemClickListener
{
  private var url: String = "https://opendata.rdw.nl/resource/m9d7-ebf2.json"
  private val gson: Gson = Gson()
  private val queue: RequestQueue = Volley.newRequestQueue(context.applicationContext)

  fun getData(lv: ListView)
  {
    //Request aanmaken
    val stringRequest = StringRequest(
      Request.Method.GET,
      url,
      { response ->
        //Ophalen van de json objecten en in json array stoppen
        val jarr = JSONArray(response)
        //Type objecten die in array geplaats moeten worden specificeren
        val arr = object : TypeToken<ArrayList<RDW>>() {}.type
        //De json array omzetten naar een array met RDW objecten
        val rdwArray = gson.fromJson<ArrayList<RDW>>(jarr.toString(), arr)
        //Opslaan welke layout gebruikt moet worden voor de list items
        val itemLayoutResId = android.R.layout.simple_list_item_2
        //ArrayAdapter aanmaken
        val ad = object : ArrayAdapter<RDW>(context, itemLayoutResId, rdwArray) {
          //Functie zorgt voor de individuele view items van de list, loopt door alle items heen
          override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            //Nieuwe view wordt gemaakt met gewenste layout voor het huidige item
            val view = convertView ?: LayoutInflater.from(context).inflate(itemLayoutResId, parent, false)
            //Het object van het huidige item wordt opgehaald
            val item = getItem(position)
            //Textview aanmaken voor het kenteken
            val kentekenTextView = view.findViewById<TextView>(android.R.id.text1)
            //Textview aanmaken voor de voertuigsoort
            val voertuigsoortTextView = view.findViewById<TextView>(android.R.id.text2)
            //Kenteken van een item in de rdw array als tekst instellen
            kentekenTextView.text = item?.kenteken ?: ""
            //Voertuigsoort van een item in de rdw array als tekst instellen
            voertuigsoortTextView.text = item?.voertuigsoort ?: ""

            return view
          }
        }

        //Deze class is een click listener, gebruikt onItemClick van deze class
        lv.onItemClickListener = this
        //Adapter instellen
        lv.adapter = ad
      },
      {

      }
    )

    //Wachten op response van de server om request uit te kunnen voeren
    queue.add(stringRequest)
  }


  override fun onItemClick(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long)
  {
    //Ophalen item uit de listview. parent? geeft aan dat hij null mag zijn, zonder te crashen
    val rdw : RDW = parent?.getItemAtPosition(position) as RDW
    //Intent aanmaken voor detail activity
    val intent = Intent(context, DetailActivity::class.java)
    //Rdw object meegeven
    intent.putExtra("rdw", rdw)
    //Activity starten
    context.startActivity(intent)
  }
}