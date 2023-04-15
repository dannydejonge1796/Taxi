package com.example.taxi.model

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
import com.example.taxi.MainActivity
import com.example.taxi.R
import com.example.taxi.ui.detail.DetailFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray

class RdwApi(private var context: MainActivity) : AdapterView.OnItemClickListener
{
  private var url: String = "https://opendata.rdw.nl/resource/m9d7-ebf2.json"
  private val gson: Gson = Gson()
  private val queue: RequestQueue = Volley.newRequestQueue(context.applicationContext)

  fun getData(lv: ListView, inputText: String?)
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
        var rdwArray = gson.fromJson<ArrayList<RDW>>(jarr.toString(), arr)
        //Als er een text is ingevoerd
        if (inputText != null) {
          //Filter de array van rdw objectem
          val filteredArray = rdwArray.filter { item ->
            item.kenteken?.contains(inputText, ignoreCase = true) == true
          }
          rdwArray = filteredArray as ArrayList<RDW>?
        }
        //Opslaan welke layout gebruikt moet worden voor de list items
        val itemLayoutResId = android.R.layout.simple_list_item_2
//        ArrayAdapter aanmaken
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
    context.supportFragmentManager.popBackStack()

    //Ophalen item uit de listview. parent? geeft aan dat hij null mag zijn, zonder te crashen
    val rdw: RDW = parent?.getItemAtPosition(position) as RDW
    //Detail fragment initialiseren
    val detailFragment = DetailFragment(rdw)
    //Vervang alle fragments met de nieuwe fragment
    context.supportFragmentManager.beginTransaction()
      .add(R.id.detailFragmentContainer, detailFragment)
      .addToBackStack(null)
      .commit()
  }
}