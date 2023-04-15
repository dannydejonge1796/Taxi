package com.example.taxi.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taxi.databinding.FragmentOverviewBinding

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

//    val lv = root.findViewById<ListView>(R.id.listOverView)
//
//    val apc = RdwApi(requireActivity() as MainActivity)
//    apc.getData(lv, null)

    return root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}