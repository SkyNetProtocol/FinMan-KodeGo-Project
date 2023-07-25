package com.example.finman1.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.finman1.ui.fragments.homefragments.ReportsFragment
import com.example.finman1.ui.fragments.reports.BalanceSheetFragment
import com.example.finman1.ui.fragments.reports.NetWorthFragment

class FragmentPageAdapter2(fragmentActivity: ReportsFragment, private var totalCount: Int) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return totalCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BalanceSheetFragment()
            else -> NetWorthFragment()
        }
    }
}