package com.example.finman1.ui.addactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.finman1.R
import com.example.finman1.application.FinManClass
import com.example.finman1.database.relations.AssetsTable
import com.example.finman1.database.relations.ExpensesTable
import com.example.finman1.databinding.ActivityAddAssetsBinding
import com.example.finman1.databinding.ActivityAddExpenseBinding
import com.example.finman1.ui.fragments.financialfragments.AssetsFragment
import com.example.finman1.ui.fragments.financialfragments.ExpensesFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddExpenseBinding

    var userRepositoryExpense = FinManClass.wordRepositoryGlobal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        attachActionsExpense()

    }
    private fun attachActionsExpense(){
        binding.btnAddExpense.setOnClickListener { addExpense() }
        binding.btnBackToExpenseFragment.setOnClickListener { backToExpenseFragment() }
    }


    private fun addExpense(){
        val expenseType = binding.expenseType.text.toString()
        val expenseQuantity = binding.expenseQuantity.text.toString()
        val dateOfExpense = binding.expenseDate.text.toString()
        val expenseName = binding.expenseParticulars.text.toString()

        val expenseToAdd = ExpensesTable(0, expenseType, expenseQuantity, dateOfExpense, expenseName)
        val newScopeExpense = CoroutineScope(Dispatchers.IO).launch{
            userRepositoryExpense.addExpenseToExpenseTable(expenseToAdd)
            Log.e("DB","___ added ___ " )
            finish()
        }

    }

    private fun backToExpenseFragment(){
        val backToExpense = Intent(this, ExpensesFragment::class.java)
        startActivity(backToExpense)
    }

}