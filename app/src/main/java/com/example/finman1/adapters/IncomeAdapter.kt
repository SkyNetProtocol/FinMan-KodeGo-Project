package com.example.finman1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.finman1.R
import com.example.finman1.dataclass.IncomeData

class IncomeAdapter (private val incomeList:ArrayList<IncomeData>)
    : RecyclerView.Adapter<IncomeAdapter.IncomeViewHolder>(){

    var onItemClick: ((IncomeData) -> Unit)? = null

    class IncomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewIncome1: TextView = itemView.findViewById(R.id.recyclerText)
        val textViewIncome2: TextView = itemView.findViewById(R.id.recyclerText2)
        val incomeSample: ConstraintLayout = itemView.findViewById(R.id.layoutBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomeViewHolder {
        val viewIncome = LayoutInflater.from(parent.context).inflate(R.layout.layout_box, parent, false)
        return IncomeViewHolder(viewIncome)
    }

    override fun getItemCount(): Int {
        return incomeList.size
    }

    override fun onBindViewHolder(holder: IncomeViewHolder, position: Int) {
        val income = incomeList[position]
        holder.textViewIncome1.text = income.income1
        holder.textViewIncome2.text = income.income2
        holder.incomeSample.setOnClickListener {
            onItemClick?.invoke(income)
        }
    }


}