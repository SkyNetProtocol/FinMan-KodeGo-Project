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
import com.example.finman1.adapters.LiabilitiesAdapter
import com.example.finman1.application.FinManClass
import com.example.finman1.database.relations.AssetsTable
import com.example.finman1.database.relations.LiabilitiesTable
import com.example.finman1.databinding.FragmentAssetsBinding
import com.example.finman1.databinding.FragmentLiabilitiesFragmentsBinding
import com.example.finman1.dataclass.AssetsData
import com.example.finman1.dataclass.LiabilitiesData
import com.example.finman1.ui.addactivity.AddAssetsActivity
import com.example.finman1.ui.addactivity.AddLiabilityActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LiabilitiesFragments : Fragment() {
    private var _binding : FragmentLiabilitiesFragmentsBinding? = null
    private val binding get() = _binding!!

    private lateinit var specificLiability: List<LiabilitiesTable>

    var liabilityRepository = FinManClass.wordRepositoryGlobal
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLiabilitiesFragmentsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.liabilityOne.setOnClickListener {
            val intentAddLiability = Intent(this.activity, AddLiabilityActivity::class.java)
            startActivity(intentAddLiability)
        }
    }
    override fun onResume() {
        super.onResume()
//        val newScope = CoroutineScope(Dispatchers.IO).launch {
        val newScopeLiability = CoroutineScope(Dispatchers.IO).launch {
//           specificUser = userRepository.getSpecific(check)
            specificLiability = liabilityRepository.getLiability()
            Log.e("DB", "___ success ___$specificLiability")
            val listLiabilityView = ArrayList<LiabilitiesData>()
            specificLiability.forEach {
                val liabilityView = LiabilitiesData(it.liabilityType,it.quantity,it.date,it.particulars)
                listLiabilityView.add(liabilityView)
            }
            withContext(Dispatchers.Main){
                displayRecyclerViewLiability(listLiabilityView)
            }
//            displayRecyclerViewAsset(listAssetView)
        }
    }

    private fun displayRecyclerViewLiability(liabilityList:ArrayList<LiabilitiesData>)
    {
        binding.recyclerViewLiability.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = LiabilitiesAdapter(liabilityList).apply {
//                    setAssetData(assetList)
            }
        }
    }

}