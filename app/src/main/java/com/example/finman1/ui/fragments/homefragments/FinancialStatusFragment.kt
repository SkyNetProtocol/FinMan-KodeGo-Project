package com.example.finman1.ui.fragments.homefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.finman1.R
import com.example.finman1.adapters.FragmentPageAdapter
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

        binding.viewPager2.adapter = FragmentPageAdapter(this,4)

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Assets"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Liability"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Income"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Expense"))

        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
//                binding.viewPager2.setCurrentItem(tab!!.position)
                binding.viewPager2.currentItem = tab!!.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)


    }

}