package com.example.finman1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.finman1.R
import com.example.finman1.dataclass.AssetsData

class AssetsAdapter (private val assetsList:ArrayList<AssetsData>)
        : RecyclerView.Adapter<AssetsAdapter.AssetsViewHolder>(){

    var onItemClick: ((AssetsData) -> Unit)? = null

    class AssetsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewAsset1: TextView = itemView.findViewById(R.id.recyclerText)
        val textViewAsset2: TextView = itemView.findViewById(R.id.recyclerText2)
        val assetSample: ConstraintLayout = itemView.findViewById(R.id.layoutBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetsViewHolder {
        val viewAssets = LayoutInflater.from(parent.context).inflate(R.layout.layout_box, parent, false)
        return AssetsViewHolder(viewAssets)
    }

    override fun getItemCount(): Int {
        return assetsList.size
    }

    override fun onBindViewHolder(holder: AssetsViewHolder, position: Int) {
        val asset = assetsList[position]
        holder.textViewAsset1.text = asset.asset1
        holder.textViewAsset2.text = asset.asset2
        holder.assetSample.setOnClickListener {
            onItemClick?.invoke(asset)
        }
    }

}