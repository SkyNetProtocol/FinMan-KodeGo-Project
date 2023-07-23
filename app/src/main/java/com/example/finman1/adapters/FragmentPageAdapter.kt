package com.example.finman1.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.finman1.ui.fragments.financialfragments.AssetsFragment
import com.example.finman1.ui.fragments.financialfragments.ExpensesFragment
import com.example.finman1.ui.fragments.financialfragments.IncomeFragment
import com.example.finman1.ui.fragments.financialfragments.LiabilitiesFragments
import com.example.finman1.ui.fragments.homefragments.FinancialStatusFragment

class FragmentPageAdapter(fragmentActivity: FinancialStatusFragment, private var totalCount: Int) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return totalCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AssetsFragment()
            1 -> LiabilitiesFragments()
            2 -> IncomeFragment()
            3 -> ExpensesFragment()
            else -> AssetsFragment()
        }
    }
}