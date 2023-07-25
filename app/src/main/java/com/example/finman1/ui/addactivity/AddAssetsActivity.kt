package com.example.finman1.ui.addactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.finman1.R
import com.example.finman1.application.FinManClass
import com.example.finman1.database.FinManDataClass
import com.example.finman1.database.relations.AssetsTable
import com.example.finman1.databinding.ActivityAddAssetsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddAssetsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddAssetsBinding

    var userRepositoryAsset = FinManClass.wordRepositoryGlobal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAssetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        attachActionsAsset()

    }
    private fun attachActionsAsset(){
        binding.btnAddAsset.setOnClickListener { addAsset() }

    }


    private fun addAsset(){
        val assetType = binding.assetType.text.toString()
        val assetQuantity = binding.assetQuantity.text.toString()
        val assetDateAcquired = binding.assetDate.text.toString()
        val assetName = binding.assetParticulars.text.toString()

        val assetToAdd = AssetsTable(0, assetType, assetQuantity, assetDateAcquired, assetName)
        val newScopeAsset = CoroutineScope(Dispatchers.IO).launch{
            userRepositoryAsset.addAssetToAssetTable(assetToAdd)
            Log.e("DB","___ added ___ " )
            finish()
        }

    }



}