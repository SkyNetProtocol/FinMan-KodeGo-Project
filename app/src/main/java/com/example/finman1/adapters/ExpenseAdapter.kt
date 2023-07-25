package com.example.finman1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.finman1.R
import com.example.finman1.dataclass.AssetsData
import com.example.finman1.dataclass.ExpenseData

class ExpenseAdapter (private val expenseList:ArrayList<ExpenseData>)
    : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>(){

    var onItemClick: ((ExpenseData) -> Unit)? = null

    class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewExpense1: TextView = itemView.findViewById(R.id.recyclerText)
        val textViewExpense2: TextView = itemView.findViewById(R.id.recyclerText2)
        val textViewExpense3: TextView = itemView.findViewById(R.id.recyclerText3)
        val textViewExpense4: TextView = itemView.findViewById(R.id.recyclerText4)
        val expenseSample: ConstraintLayout = itemView.findViewById(R.id.layoutBoxAsset)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val viewExpense = LayoutInflater.from(parent.context).inflate(R.layout.layout_box_asset, parent, false)
        return ExpenseViewHolder(viewExpense)
    }

    override fun getItemCount() = expenseList.size
    fun setAssetData(data: List<ExpenseData>){
        expenseList.apply {
            clear()
            addAll(data)
        }
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenseList[position]
        holder.textViewExpense1.text = expense.expense1
        holder.textViewExpense2.text = expense.expense2
        holder.textViewExpense3.text = expense.expense3
        holder.textViewExpense4.text = expense.expense4
        holder.expenseSample.setOnClickListener {
            onItemClick?.invoke(expense)
        }
    }


}