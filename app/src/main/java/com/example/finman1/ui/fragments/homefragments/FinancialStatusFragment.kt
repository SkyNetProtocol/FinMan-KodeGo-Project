package com.example.finman1.ui.fragments.homefragments

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.finman1.R
import com.example.finman1.adapters.FragmentPageAdapter
import com.example.finman1.databinding.FragmentAssetsBinding
import com.example.finman1.databinding.FragmentFinancialStatusBinding
import com.google.android.material.tabs.TabLayout

class FinancialStatusFragment : Fragment() {
    private var _binding : FragmentFinancialStatusBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinancialStatusBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    }

}