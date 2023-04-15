package com.example.taxi.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.taxi.R
import com.example.taxi.model.RDW

class DetailFragment(private var rdw: RDW) : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_detail, container, false)

    (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Detail"

    //Textviews uit view ophalen
    val tvLicense = view.findViewById<TextView>(R.id.tvLicense)
    val tvType = view.findViewById<TextView>(R.id.tvType)

    //Text instellen met waardes uit het object
    tvLicense.text = rdw.kenteken
    tvType.text = rdw.voertuigsoort

    return view
  }
}