package com.example.taxi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

  private var textView: TextView? = null

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_list, container, false)
    //Tekst view ophalen d.m.v. het id
    textView = view.findViewById(R.id.textView)
    return view
  }

  fun updateText(inputText: String)
  {
    //Bericht klaarmaken
    val message = getString(R.string.input_text_message, inputText)
    //Bericht als tekst instellen
    textView?.text = message
  }
}
