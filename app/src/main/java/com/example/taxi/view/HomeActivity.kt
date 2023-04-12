package com.example.taxi.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.taxi.R
import com.example.taxi.model.RdwApi

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

    val apc = RdwApi(this)

    //List fragment initialiseren
    val listFragment = ListFragment(apc)
    //List fragment inladen
    supportFragmentManager.beginTransaction().add(android.R.id.content, listFragment, "LIST_FRAGMENT").commit()
  }
}