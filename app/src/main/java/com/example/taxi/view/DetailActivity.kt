package com.example.taxi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.taxi.R
import com.example.taxi.model.RDW

class DetailActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    //Toolbar ophalen en als default toolbar instellen
    val toolbar = findViewById<Toolbar>(R.id.toolbar)
    setSupportActionBar(toolbar)

    //Terugknop aanzetten
    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    //Klik actie instellen
    toolbar.setNavigationOnClickListener {
      finish()
    }

    //Detail pagina init
    this.initDetailPage()
  }

  private fun initDetailPage()
  {
    //Rdw object uit intent halen
    val rdw = this.intent.getParcelableExtra<RDW>("rdw")

    //Textviews uit view ophalen
    val tvLicense = findViewById<TextView>(R.id.tvLicense)
    val tvType = findViewById<TextView>(R.id.tvType)

    //Text instellen met waardes uit het object
    tvLicense.text = rdw?.kenteken
    tvType.text = rdw?.voertuigsoort
  }
}