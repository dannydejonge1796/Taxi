package com.example.taxi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.taxi.R
import com.example.taxi.model.RdwApi

class ListFragment(private var apc: RdwApi) : Fragment() {

  private var textView: TextView? = null
  private var listView: ListView? = null

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_list, container, false)
    //Tekst view ophalen d.m.v. het id
    textView = view.findViewById(R.id.textView)
    //List view ophalen d.m.v. het id
    listView = view.findViewById(R.id.listView)

    return view
  }

  fun updateText(inputText: String)
  {
    //Bericht klaarmaken
    val message = getString(R.string.input_text_message, inputText)
    //Bericht als tekst instellen
    textView?.text = message
    //Get data functie aanroepen in de rdw api class, lv en tekst meegeven
    apc.getData(listView!!, inputText)
  }
}
