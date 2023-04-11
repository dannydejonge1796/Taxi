package com.example.taxi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        //Knop ophalen d.m.v. van het id
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        //Wanneer op knop wordt gedrukt
        btnSearch.setOnClickListener {
            //Text veld ophalen d.m.v. id
            val textField = findViewById<EditText>(R.id.tfSearch)
            //Text opslaan als string
            val text = textField.text.toString()

            //Uitprinten
            println(text)
        }
    }
}