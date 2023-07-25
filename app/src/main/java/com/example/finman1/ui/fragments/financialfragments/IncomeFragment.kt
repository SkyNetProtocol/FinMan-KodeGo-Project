package com.example.finman1.ui.fragments.financialfragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finman1.adapters.AssetsAdapter
import com.example.finman1.adapters.IncomeAdapter
import com.example.finman1.application.FinManClass
import com.example.finman1.database.relations.IncomeTable
import com.example.finman1.databinding.FragmentIncomeBinding
import com.example.finman1.dataclass.AssetsData
import com.example.finman1.dataclass.IncomeData
import com.example.finman1.ui.addactivity.AddIncomeActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class IncomeFragment : Fragment() {
    private var _binding : FragmentIncomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var specificIncome: List<IncomeTable>

    var incomeRepository = FinManClass.wordRepositoryGlobal
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIncomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.incomeOne.setOnClickListener {
            val intentAddIncome = Intent(this.activity, AddIncomeActivity::class.java)
            startActivity(intentAddIncome)

        }
    }
    override fun onResume() {
        super.onResume()
//        val newScope = CoroutineScope(Dispatchers.IO).launch {
        val newScopeIncome = CoroutineScope(Dispatchers.IO).launch {
//           specificUser = userRepository.getSpecific(check)
            specificIncome = incomeRepository.getIncome()
            Log.e("DB", "___ success ___$specificIncome")
            val listIncomeView = ArrayList<IncomeData>()
            specificIncome.forEach {
                val incomeView = IncomeData(it.incomeType,it.quantity,it.date,it.resource)
                listIncomeView.add(incomeView)
            }
            withContext(Dispatchers.Main){
                displayRecyclerViewIncome(listIncomeView)
            }
//            displayRecyclerViewAsset(listAssetView)
        }
    }

    private fun displayRecyclerViewIncome(incomeList:ArrayList<IncomeData>)
    {
        binding.recyclerViewIncome.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = IncomeAdapter(incomeList).apply {
//                    setAssetData(assetList)
            }
        }
    }

}