package com.example.finman1.ui.addactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.finman1.R
import com.example.finman1.application.FinManClass
import com.example.finman1.database.relations.AssetsTable
import com.example.finman1.database.relations.IncomeTable
import com.example.finman1.databinding.ActivityAddAssetsBinding
import com.example.finman1.databinding.ActivityAddIncomeBinding
import com.example.finman1.ui.fragments.financialfragments.AssetsFragment
import com.example.finman1.ui.fragments.financialfragments.IncomeFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddIncomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddIncomeBinding

    var userRepositoryIncome = FinManClass.wordRepositoryGlobal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        attachActionsIncome()
    }

    private fun attachActionsIncome(){
        binding.btnAddIncome.setOnClickListener { addIncome() }
        binding.btnBackToIncomeFragment.setOnClickListener { backToIncomeFragment() }
    }


    private fun addIncome(){
        val incomeType = binding.incomeType.text.toString()
        val incomeQuantity = binding.incomeQuantity.text.toString()
        val incomeDateAcquired = binding.incomeDate.text.toString()
        val incomeName = binding.incomeParticulars.text.toString()

        val incomeToAdd = IncomeTable(0, incomeType, incomeQuantity, incomeDateAcquired, incomeName)
        val newScopeIncome = CoroutineScope(Dispatchers.IO).launch{
            userRepositoryIncome.addIncomeToIncomeTable(incomeToAdd)
            Log.e("DB","___ added ___ " )
            finish()
        }
    }

    private fun backToIncomeFragment(){
        val backToIncome = Intent(this, IncomeFragment::class.java)
        startActivity(backToIncome)
    }

}