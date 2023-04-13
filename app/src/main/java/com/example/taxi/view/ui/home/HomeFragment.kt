package com.example.taxi.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taxi.R
import com.example.taxi.databinding.FragmentHomeBinding
import com.example.taxi.model.RdwApi
import com.example.taxi.view.ListFragment
import com.example.taxi.view.MainActivity
import com.example.taxi.view.SearchFragment

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

    // Search fragment initialiseren
    val searchFragment = SearchFragment()
    // Search fragment inladen
    childFragmentManager.beginTransaction().add(R.id.searchFragmentContainer, searchFragment, "SEARCH_FRAGMENT").commit()

    // List fragment initialiseren
    val listFragment = ListFragment(apc)
    // List fragment inladen
    childFragmentManager.beginTransaction().add(R.id.listFragmentContainer, listFragment, "LIST_FRAGMENT").commit()

    return root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}
