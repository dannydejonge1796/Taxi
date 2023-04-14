package com.example.taxi

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.taxi.databinding.ActivityMainBinding
import com.example.taxi.ui.home.DetailFragment
import com.example.taxi.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val navView: BottomNavigationView = binding.navView

    val navController = findNavController(R.id.nav_host_fragment_activity_main)
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    val appBarConfiguration = AppBarConfiguration(
      setOf(
        R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
      )
    )
    setupActionBarWithNavController(navController, appBarConfiguration)
    navView.setupWithNavController(navController)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean
  {
    //Roep de on back pressed functie aan wanneer de terugknop in de action wordt aangeklikt
    return when (item.itemId) {
      android.R.id.home -> {
        onBackPressed()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  override fun onBackPressed()
  {
    //Huidige fragment ophalen
    val currentFragment = supportFragmentManager.findFragmentById(R.id.container)
    //Als het fragment detail fragment is
    if (currentFragment is DetailFragment) {
      supportActionBar?.setDisplayHomeAsUpEnabled(false)
      supportActionBar?.title = "Taxi"

      val fragmentManager = supportFragmentManager
      val fragmentTransaction = fragmentManager.beginTransaction()

      val homeFragment = HomeFragment()
      fragmentTransaction.replace(R.id.container, homeFragment)
      fragmentTransaction.commit()

    } else {
      super.onBackPressed()
    }
  }
}