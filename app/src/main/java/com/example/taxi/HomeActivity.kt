package com.example.taxi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar

class HomeActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    //Toolbar ophalen en als default toolbar instellen
    val toolbar = findViewById<Toolbar>(R.id.toolbar)
    setSupportActionBar(toolbar)

    //Homepagina initialiseren
    this.initHomePage()
  }

  private fun initHomePage()
  {
    //Knop ophalen d.m.v. van het id
    val btnSearch = findViewById<Button>(R.id.btnSearch)
    //Wanneer op knop wordt gedrukt
    btnSearch.setOnClickListener {
      //Text veld ophalen d.m.v. id
      val textField = findViewById<EditText>(R.id.tfSearch)
      //Text opslaan als string
      val text = textField.text.toString()
      //Andere activiteit aanroepen
      val intent = Intent(this, ListActivity::class.java)
      //Text meegeven aan andere activiteit
      intent.putExtra("input_text", text)
      //Activiteit starten
      startActivity(intent)
    }
  }
}