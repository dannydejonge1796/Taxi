package com.example.taxi.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.taxi.MainActivity
import com.example.taxi.R
import com.example.taxi.databinding.FragmentOverviewBinding
import com.example.taxi.model.RdwApi

class OverviewFragment : Fragment() {

  private var _binding: FragmentOverviewBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentOverviewBinding.inflate(inflater, container, false)
    val root: View = binding.root

    //Overview ijst ophalen met id
    val lv = root.findViewById<ListView>(R.id.listOverView)

    //Rdw api class initialiseren
    val apc = RdwApi(requireActivity() as MainActivity)
    //Get data functie aanroepen, om data in lijst te stoppen
    apc.getData(lv, null)

    return root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}