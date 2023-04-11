package com.example.taxi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class ListActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list)

    //Toolbar ophalen en als default toolbar instellen
    val toolbar = findViewById<Toolbar>(R.id.toolbar)
    setSupportActionBar(toolbar)

    //Tekst weergeven
    this.showText()
  }

  private fun showText()
  {
    //Tekstveld ophalen d.m.v.
    val textView = findViewById<TextView>(R.id.textView)
    //Meegegeven data ophalen
    val inputText = intent.getStringExtra("input_text")
    //Bericht klaarmaken
    val message = getString(R.string.input_text_message, inputText)
    //Bericht als tekst instellen
    textView.text = message
  }
}