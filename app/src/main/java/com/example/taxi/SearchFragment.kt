package com.example.taxi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class SearchFragment : Fragment() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {

    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_search, container, false)
    //Knop ophalen d.m.v. van het id
    val btnSearch = view.findViewById<Button>(R.id.btnSearch)
    //Wanneer op knop wordt gedrukt
    btnSearch.setOnClickListener {
      //Tekst veld ophalen d.m.v. id
      val textField = view.findViewById<EditText>(R.id.tfSearch)
      //Tekst opslaan als string
      val text = textField.text.toString()
      //List fragment ophalen met tag
      val listFragment = parentFragmentManager.findFragmentByTag("LIST_FRAGMENT") as ListFragment
      //Update tekst functie aanroepen in list fragment
      listFragment.updateText(text)
    }

    return view
  }

}
