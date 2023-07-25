package com.example.finman1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.finman1.R
import com.example.finman1.dataclass.AssetsData
import com.example.finman1.dataclass.LiabilitiesData

class LiabilitiesAdapter (private val liabilitiesList:ArrayList<LiabilitiesData>)
    : RecyclerView.Adapter<LiabilitiesAdapter.LiabilitiesViewHolder>(){

    var onItemClick: ((LiabilitiesData) -> Unit)? = null

    class LiabilitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewLiability1: TextView = itemView.findViewById(R.id.recyclerText)
        val textViewLiability2: TextView = itemView.findViewById(R.id.recyclerText2)
        val textViewLiability3: TextView = itemView.findViewById(R.id.recyclerText3)
        val textViewLiability4: TextView = itemView.findViewById(R.id.recyclerText4)
        val liabilitySample: ConstraintLayout = itemView.findViewById(R.id.layoutBoxAsset)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiabilitiesViewHolder {
        val viewLiabilities = LayoutInflater.from(parent.context).inflate(R.layout.layout_box_asset, parent, false)
        return LiabilitiesViewHolder(viewLiabilities)
    }

    override fun getItemCount() = liabilitiesList.size
    //        override fun getItemCount(): Int {
//        return assetsList.size
    fun setLiabilityData(data: List<LiabilitiesData>){
        liabilitiesList.apply {
            clear()
            addAll(data)
        }
    }

    override fun onBindViewHolder(holder: LiabilitiesViewHolder, position: Int) {
        val liabilities = liabilitiesList[position]
        holder.textViewLiability1.text = liabilities.liability1
        holder.textViewLiability2.text = liabilities.liability2
        holder.textViewLiability3.text = liabilities.liability3
        holder.textViewLiability4.text = liabilities.liability4
        holder.liabilitySample.setOnClickListener {
            onItemClick?.invoke(liabilities)
        }
    }
}