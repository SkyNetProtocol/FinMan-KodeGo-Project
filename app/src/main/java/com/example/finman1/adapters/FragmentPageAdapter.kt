package com.example.finman1.adapters

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.finman1.ui.fragments.financialfragments.AssetsFragment
import com.example.finman1.ui.fragments.financialfragments.ExpensesFragment
import com.example.finman1.ui.fragments.financialfragments.IncomeFragment
import com.example.finman1.ui.fragments.financialfragments.LiabilitiesFragments

class FragmentPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                AssetsFragment()
            }
            1 -> {
                LiabilitiesFragments()
            }
            2 -> {
                IncomeFragment()
            }
            3 -> {
                ExpensesFragment()
            }
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }
    }

}