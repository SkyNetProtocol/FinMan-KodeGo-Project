package com.example.finman1.ui.fragments.financialfragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finman1.R
import com.example.finman1.adapters.AssetsAdapter
import com.example.finman1.adapters.ExpenseAdapter
import com.example.finman1.application.FinManClass
import com.example.finman1.database.relations.AssetsTable
import com.example.finman1.database.relations.ExpensesTable
import com.example.finman1.databinding.FragmentAssetsBinding
import com.example.finman1.databinding.FragmentExpensesBinding
import com.example.finman1.dataclass.AssetsData
import com.example.finman1.dataclass.ExpenseData
import com.example.finman1.ui.addactivity.AddAssetsActivity
import com.example.finman1.ui.addactivity.AddExpenseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ExpensesFragment : Fragment() {
    private var _binding : FragmentExpensesBinding? = null
    private val binding get() = _binding!!

    private lateinit var specificExpense: List<ExpensesTable>

    var expenseRepository = FinManClass.wordRepositoryGlobal
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpensesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.expenseOne.setOnClickListener {
            val intentAddExpense = Intent(this.activity, AddExpenseActivity::class.java)
            startActivity(intentAddExpense)

        }
    }
    override fun onResume() {
        super.onResume()
//        val newScope = CoroutineScope(Dispatchers.IO).launch {
        val newScopeExpense = CoroutineScope(Dispatchers.IO).launch {
//           specificUser = userRepository.getSpecific(check)
            specificExpense = expenseRepository.getExpense()
            Log.e("DB", "___ success ___$specificExpense")
            val listExpenseView = ArrayList<ExpenseData>()
            specificExpense.forEach {
                val expenseView = ExpenseData(it.expenseType,it.quantity,it.date,it.particulars)
                listExpenseView.add(expenseView)
            }
            withContext(Dispatchers.Main){
                displayRecyclerViewExpense(listExpenseView)
            }
//            displayRecyclerViewAsset(listAssetView)
        }
    }

    private fun displayRecyclerViewExpense(expenseList:ArrayList<ExpenseData>)
    {
        binding.recyclerViewExpense.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ExpenseAdapter(expenseList).apply {
//                    setAssetData(assetList)
            }
        }
    }
}