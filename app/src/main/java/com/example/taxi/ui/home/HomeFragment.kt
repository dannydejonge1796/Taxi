package com.example.taxi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taxi.MainActivity
import com.example.taxi.R
import com.example.taxi.databinding.FragmentHomeBinding
import com.example.taxi.model.RdwApi

class HomeFragment : Fragment() {

  private var _binding: FragmentHomeBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentHomeBinding.inflate(inflater, container, false)

    //Alles in de backstack verwijderen
    childFragmentManager.popBackStack()

    //Rdw api class initialiseren
    val apc = RdwApi(requireActivity() as MainActivity)

    //Frament manager ophalen
    val fragmentManager = childFragmentManager

    //Transactie starten
    val fragmentTransaction = fragmentManager.beginTransaction()

    //Nieuwe instantie search fragment
    val searchFragment = SearchFragment()
    //Search fragment toevoegen aan transactie
    fragmentTransaction.add(R.id.searchFragmentContainer, searchFragment)

    //Nieuwe instantie list fragment
    val listFragment = ListFragment(apc)
    //List fragment toevoegen aan transactie
    fragmentTransaction.add(R.id.listFragmentContainer, listFragment)

    //Zorgt dat je kan terug navigeren
    fragmentTransaction.addToBackStack(null)
    //Commit de transactie
    fragmentTransaction.commit()

    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}
