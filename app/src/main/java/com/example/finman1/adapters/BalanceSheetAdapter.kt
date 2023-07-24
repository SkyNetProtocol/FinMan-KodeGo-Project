package com.example.finman1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.finman1.R
import com.example.finman1.dataclass.BalanceSheetData

class BalanceSheetAdapter (private val balanceSheetList:ArrayList<BalanceSheetData>)
     : RecyclerView.Adapter<BalanceSheetAdapter.BalanceSheetViewHolder>(){

    var onItemClick: ((BalanceSheetData) -> Unit)? = null

    class BalanceSheetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewBalanceSheet1: TextView = itemView.findViewById(R.id.recyclerText)
        val textViewBalanceSheet2: TextView = itemView.findViewById(R.id.recyclerText2)
        val balanceSheetSample: ConstraintLayout = itemView.findViewById(R.id.layoutBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BalanceSheetViewHolder {
        val viewBalanceSheet = LayoutInflater.from(parent.context).inflate(R.layout.layout_box, parent, false)
        return BalanceSheetViewHolder(viewBalanceSheet)
    }

    override fun getItemCount(): Int {
        return balanceSheetList.size
    }

    override fun onBindViewHolder(holder: BalanceSheetViewHolder, position: Int) {
        val balanceSheet = balanceSheetList[position]
        holder.textViewBalanceSheet1.text = balanceSheet.balanceSheet1
        holder.textViewBalanceSheet2.text = balanceSheet.balanceSheet2
        holder.balanceSheetSample.setOnClickListener {
            onItemClick?.invoke(balanceSheet)
        }
    }


}