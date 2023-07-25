package com.example.finman1.ui.addactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.finman1.R
import com.example.finman1.application.FinManClass
import com.example.finman1.database.relations.AssetsTable
import com.example.finman1.database.relations.LiabilitiesTable
import com.example.finman1.databinding.ActivityAddAssetsBinding
import com.example.finman1.databinding.ActivityAddLiabilityBinding
import com.example.finman1.ui.fragments.financialfragments.LiabilitiesFragments
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddLiabilityActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddLiabilityBinding

    var userRepositoryLiability = FinManClass.wordRepositoryGlobal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddLiabilityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        attachActionsLiability()

    }
    private fun attachActionsLiability(){
        binding.btnAddLiability.setOnClickListener { addLiability() }
        binding.btnBackToLiabilityFragment.setOnClickListener { backToLiabilityFragment() }
    }


    private fun addLiability(){
        val liabilityType = binding.liabilityType.text.toString()
        val liabilityQuantity = binding.liabilityQuantity.text.toString()
        val liabilityDateAcquired = binding.liabilityDate.text.toString()
        val liabilityName = binding.liabilityParticulars.text.toString()

        val liabilityToAdd = LiabilitiesTable(0, liabilityType, liabilityQuantity, liabilityDateAcquired, liabilityName)
        val newScopeLiability = CoroutineScope(Dispatchers.IO).launch{
            userRepositoryLiability.addLiabilityToLiabilityTable(liabilityToAdd)
            Log.e("DB","___ added ___ " )
            finish()
        }

    }

    private fun backToLiabilityFragment(){
        val backToLiability = Intent(this, LiabilitiesFragments::class.java)
        startActivity(backToLiability)
    }

}