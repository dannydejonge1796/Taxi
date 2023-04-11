package com.example.taxi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
    //Search fragment initialiseren
    val searchFragment = SearchFragment()
    //Search fragment inladen
    supportFragmentManager.beginTransaction().add(android.R.id.content, searchFragment, "SEARCH_FRAGMENT").commit()

    //List fragment initialiseren
    val listFragment = ListFragment()
    //List fragment inladen
    supportFragmentManager.beginTransaction().add(android.R.id.content, listFragment, "LIST_FRAGMENT").commit()
  }
}