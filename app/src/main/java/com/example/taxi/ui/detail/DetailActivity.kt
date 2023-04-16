package com.example.taxi.ui.detail

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.taxi.R
import com.example.taxi.model.RDW

class DetailActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    //Terug knop actionbar aanzetten
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    //Titel actionbar wijzigen
    supportActionBar?.title = "Detail"

    //Textviews uit view ophalen
    val tvLicense = findViewById<TextView>(R.id.tvLicense)
    val tvType = findViewById<TextView>(R.id.tvType)
    val tvBrand = findViewById<TextView>(R.id.tvBrand)
    val tvTradeName = findViewById<TextView>(R.id.tvTradeName)
    val tvColor = findViewById<TextView>(R.id.tvColor)
    val tvDesign = findViewById<TextView>(R.id.tvDesign)
    val tvSeats = findViewById<TextView>(R.id.tvSeats)

    //Meegegeven rdw object ophalen
    val rdw = intent.getParcelableExtra<RDW>("rdw")

    //Tekst instellen met waardes uit het object
    if (rdw != null) {
      tvLicense.text = rdw.kenteken
      tvType.text = rdw.voertuigsoort
      tvBrand.text = rdw.merk
      tvTradeName.text = rdw.handelsbenaming
      tvColor.text = rdw.eerste_kleur
      tvDesign.text = rdw.inrichting
      tvSeats.text = rdw.aantal_zitplaatsen
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    //Handle de onclick van teruhknop
    if (item.itemId == android.R.id.home) {
      onBackPressed()
      return true
    }

    return super.onOptionsItemSelected(item)
  }
}