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
import com.google.firebase.firestore.FirebaseFirestore
import io.realm.kotlin.internal.platform.threadId
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AssetsFragment : Fragment() {
    private var _binding : FragmentAssetsBinding? = null
    private val binding get() = _binding!!

    private lateinit var specificAsset: List<AssetsTable>
    private var fdb = FirebaseFirestore.getInstance()

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

        binding.sync.setOnClickListener {
            saveToFireStoreAsset()
        }

    }
    override fun onResume() {
        super.onResume()
//        val newScope = CoroutineScope(Dispatchers.IO).launch {
//        val newScopeAsset = CoroutineScope(Dispatchers.IO).launch {
            CoroutineScope(Dispatchers.IO).launch {
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

    fun saveToFireStoreAsset(){
        FirebaseFirestore.setLoggingEnabled(true);
        val sampleUser: MutableMap<String, Any> = HashMap()
        sampleUser["assets"]      = specificAsset
//        sampleUser["image_url"] = url

        fdb.collection("assetReports")
            .add(sampleUser)
            .addOnSuccessListener {
                Log.e("FIRE", "Success")
//                apiCall()
            }
            .addOnFailureListener { Log.e("FIRE", "Failed > " + it.toString()) }

    }

}