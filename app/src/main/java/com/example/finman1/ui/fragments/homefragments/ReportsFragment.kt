package com.example.finman1.ui.fragments.homefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.finman1.adapters.FragmentPageAdapter
import com.example.finman1.adapters.FragmentPageAdapter2
import com.example.finman1.databinding.FragmentReportsBinding
import com.google.android.material.tabs.TabLayout


class ReportsFragment : Fragment() {
    private var _binding : FragmentReportsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportsBinding.inflate(inflater, container, false)

        binding.viewPagerReports.adapter = FragmentPageAdapter2(this,2)

        binding.tabLayoutReports.addTab(binding.tabLayoutReports.newTab().setText("Balance Sheet"))
        binding.tabLayoutReports.addTab(binding.tabLayoutReports.newTab().setText("Net Worth"))


        binding.tabLayoutReports.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
//                binding.viewPager2.setCurrentItem(tab!!.position)
                binding.viewPagerReports.currentItem = tab!!.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        binding.viewPagerReports.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayoutReports.selectTab(binding.tabLayoutReports.getTabAt(position))
            }
        })
        return binding.root
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_reports, container, false)
//    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    }

}