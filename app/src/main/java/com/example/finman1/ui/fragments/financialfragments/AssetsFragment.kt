package com.example.finman1.ui.fragments.financialfragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finman1.adapters.AssetsAdapter
import com.example.finman1.application.FinManClass
import com.example.finman1.database.FinManDataClass
import com.example.finman1.database.UserDatabase
import com.example.finman1.database.relations.AssetsTable
import com.example.finman1.databinding.FragmentAssetsBinding
import com.example.finman1.dataclass.AssetsData
import com.example.finman1.ui.addactivity.AddAssetsActivity
import io.realm.kotlin.internal.platform.threadId
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AssetsFragment : Fragment() {
    private var _binding : FragmentAssetsBinding? = null
    private val binding get() = _binding!!

    private lateinit var allWordsData: List<AssetsTable>

    private lateinit var specificAsset: List<AssetsTable>

    var assetRepository = FinManClass.wordRepositoryGlobal
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAssetsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.assetsOne.setOnClickListener {
            val intentAddAsset = Intent(this.activity, AddAssetsActivity::class.java)
            startActivity(intentAddAsset)

        }
    }
    override fun onResume() {
        super.onResume()
//        val newScope = CoroutineScope(Dispatchers.IO).launch {
        val newScope = CoroutineScope(Dispatchers.IO).launch {
//           specificUser = userRepository.getSpecific(check)
            specificAsset = assetRepository.getAssets()
            Log.e("DB", "___ success ___$specificAsset")
            val listAssetView = ArrayList<AssetsData>()
            specificAsset.forEach {
                val assetView = AssetsData(it.assetType,it.quantity,it.date,it.particulars)
                listAssetView.add(assetView)
            }
            withContext(Dispatchers.Main){
                displayRecyclerViewAsset(listAssetView)
            }
//            displayRecyclerViewAsset(listAssetView)
        }
    }

    private fun displayRecyclerViewAsset(assetList:ArrayList<AssetsData>)
    {
        binding.recyclerViewAsset.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = AssetsAdapter(assetList).apply {
//                    setAssetData(assetList)
            }
        }
    }
//        lifecycleScope.launch {
//           val assetListMain = UserDatabase(mContext).userDao().getAllUser()
//            binding.recyclerViewAsset.apply {
//                layoutManager = LinearLayoutManager(this@AssetsFragment)
//                adapter = AssetsAdapter().apply {
//                    setAssetData(assetListMain)
//                }
//            }
//        }
//                    withContext(Dispatchers.Main){
//                            quotesAdapter.updateList(bod.results)
//                            updatePage(bod.totalPages)
//                            binding.tvPage.text = bod.page.toString()
//                    }

//    private fun getItems(){
//        val newScope1 = CoroutineScope(Dispatchers.IO).launch{
//            allWordsData = assetRepository.getAssets()
//            Log.e("DB","<<words>>")
//            allWordsData.forEach {
//                Log.e("DB",it.assetType.toString() +" "+ it.id)
//            }
//        }
//    }

}