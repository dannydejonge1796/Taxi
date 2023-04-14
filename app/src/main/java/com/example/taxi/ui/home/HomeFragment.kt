package com.example.taxi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taxi.R
import com.example.taxi.databinding.FragmentHomeBinding
import com.example.taxi.model.RdwApi
import com.example.taxi.MainActivity

class HomeFragment : Fragment() {

  private var _binding: FragmentHomeBinding? = null
  private lateinit var apc: RdwApi

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root

    // Initialize RdwApi
    apc = RdwApi(requireActivity() as MainActivity)

    //Frament manager ophalen
    val fragmentManager = childFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()

    //Search fragment initialiseren
    val searchFragment = SearchFragment()
    //Search fragment toevoegen aan transactie
    fragmentTransaction.add(R.id.searchFragmentContainer, searchFragment)

    //List fragment initialiseren
    val listFragment = ListFragment(apc)
    //List fragment toevoegen aan transactie
    fragmentTransaction.add(R.id.listFragmentContainer, listFragment)

    //Zorgt dat je kan terug navigeren
    fragmentTransaction.addToBackStack(null)
    //Commit de transactie
    fragmentTransaction.commit()

    return root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}
